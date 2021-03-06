package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class TopicController {

    def emailInviteService
    def groovyPageRenderer

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        println params
        params.max = Math.min(max ?: 10, 100)
        [topicInstanceList: Topic.list(params), topicInstanceTotal: Topic.count()]
    }

    def create() {
        [topicInstance: new Topic(params)]
    }

    def save() {
        def topicInstance = new Topic(params)
        if (!topicInstance.save(flush: true)) {
            render(view: "create", model: [topicInstance: topicInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'topic.label', default: 'Topic'), topicInstance.id])
        redirect(action: "show", id: topicInstance.id)
    }

    def show(Long id) {
        def topicInstance = Topic.get(id)
        if (!topicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "list")
            return
        }

        [topicInstance: topicInstance]
    }

    def edit(Long id) {
        def topicInstance = Topic.get(id)
        if (!topicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "list")
            return
        }

        [topicInstance: topicInstance]
    }

    def update(Long id, Long version) {
        def topicInstance = Topic.get(id)
        if (!topicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (topicInstance.version > version) {
                topicInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'topic.label', default: 'Topic')] as Object[],
                        "Another user has updated this Topic while you were editing")
                render(view: "edit", model: [topicInstance: topicInstance])
                return
            }
        }

        topicInstance.properties = params

        if (!topicInstance.save(flush: true)) {
            render(view: "edit", model: [topicInstance: topicInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'topic.label', default: 'Topic'), topicInstance.id])
        redirect(action: "show", id: topicInstance.id)
    }

    def delete(Long id) {
        def topicInstance = Topic.get(id)
        if (!topicInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "list")
            return
        }

        try {
            topicInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'topic.label', default: 'Topic'), id])
            redirect(action: "show", id: id)
        }
    }

    def sendInvite(VaildatorCO validateCO) {

//        println params.topicIdList
//        println params.topicIdList.getClass().name

        def topics = params.topicIdList

//        def topicsNew = topics.split(',')
//
//        println topicsNew
//
//        List<String> topicIds = params.list("topicIdList")
//
//        List<Long> topicIdsList = topicIds.collect {String topicId ->
//
//            topicId.toLong()
//
//        }

        def topicsList = topics.collect {id ->
            Topic topic = Topic.get(id)
            topic.name
        }
        println topicsList

        emailInviteService.sendInviteMail(validateCO, topicsList)
    }

    def sendMail() {

        emailInviteService.sendMailReminder()
    }

    def sendMailAccordingToDate() {

        emailInviteService.sendReminderAccordingToDate()
    }

    def renderDocument() {
        def id = params.topic.id
        render template: "../documentResource/addDocument", model: [id: id]
    }

    def addSubscriptionToUser() {

        def topicIdsNew = params.item

        println params.item.getClass().name

        def topicNewList = topicIdsNew.split(',')

        List<Long> topicIdsList = topicNewList.collect {String topicId ->

            topicId.toLong()

        }

        User user = User.findByEmail(session.userEmail)

        topicIdsList.each {Long id ->
            Topic topicNew = Topic.get(id)
            user.addToSubscriptions(new Subscription(topic: topicNew, seriousness: Seriousness.SERIOUS)).save(flush: true, failOnError: true)
        }

        topicIdsList.each {Long id ->
            Topic topicNew = Topic.get(id)
            topicNew.resources.each {Resource resource ->
                user.addToReadingitems(new ReadingItem(isFavourite: false, isRead: false, user: user, resourceItem: resource)).save(failOnError: true, flush: true)
            }
        }

        render "true"
    }

    def removeSubscriptionFromUser() {

        def topicIdsNew = params.item

        def topicNewList = topicIdsNew.split(',')

        List<Long> topicIdsList = topicNewList.collect {String topicId ->

            topicId.toLong()

        }

        User user = User.findByEmail(session.userEmail)
        List<ReadingItem> readingItems = topicIdsList ? ReadingItem.createCriteria().list {
            eq('user', user)
            'resourceItem' {
                'topic' {
                    inList('id', topicIdsList)
                }
            }
        } : []

        readingItems*.delete(flush: true)

        List<Subscription> subscriptions = topicIdsList ? Subscription.createCriteria().list {

            eq('subscriber', user)

            'topic' {
                inList('id', topicIdsList)
            }
        } : []

        subscriptions*.delete(flush: true)

//        topicIdsList.each {Long id ->
//            Topic topicNew = Topic.get(id)
//            Subscription subscription = Subscription.findBySubscriberAndTopic(user, topicNew)
//            subscription.delete(flush: true)
//        }
//            subscription.topic.resources.each {Resource resource ->
//                List<ReadingItem> toBeDeletedItems = []
//                resource.readingitems.each {ReadingItem readingItem ->
//                    if (readingItem.user == user) {
//                        toBeDeletedItems.add(readingItem)
//                    }
//                }
//                toBeDeletedItems*.delete(flush: true)
//
//            }
//            subscription.delete(flush: true)
//        }
//
        render "true"
    }

    def toggleLike() {
        Subscription subscription = params.id ? Subscription.get(params.id) : null
        String likeImage = resource(dir: 'images', file: 'like-icon.png')
        if (subscription) {
            subscription.isLike = !subscription.isLike
        }
        render subscription?.isLike ? "<img class='imageUnLike' height='30' name='Liked' src='${likeImage}' alt='true'>" : 'Like This'
    }
}