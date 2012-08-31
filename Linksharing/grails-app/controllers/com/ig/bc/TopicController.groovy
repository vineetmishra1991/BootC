package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class TopicController {

    def emailInviteService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
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
///        println "Errors in BookCommand : " + validateEmail.errors
////        if(validateEmail.hasErrors()){println "error"}
//        println "hey"
//      if (!validateCO.validate()){
//
//           validateCO.errors.allErrors.each {
//              println it
//           }
//      }
        emailInviteService.sendInviteMail(validateCO)

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
        List<String> topicIds = params.list("topicIds")
        List<Long> topicIdsList = topicIds.collect {String topicId ->

            topicId.toLong()

        }

        User user = User.findByEmail(session.userEmail)
        println user.firstname
        topicIdsList.each {Long id ->
            Topic topicNew = Topic.get(id)
            println topicNew
            user.addToSubscriptions(new Subscription(topic: topicNew,seriousness: Seriousness.SERIOUS)).save(flush: true, failOnError: true)
        }
         redirect(controller: 'login',action: 'loginHandler')
    }

}
