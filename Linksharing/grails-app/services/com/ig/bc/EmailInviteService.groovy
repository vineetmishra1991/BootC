package com.ig.bc

class EmailInviteService {
    static transactional = false
    def mailService
    def asynchronousMailService
    def groovyPageRenderer

    def serviceMethod() {

    }

    def sendInviteMail(VaildatorCO validateCO, def topicsList) {

        if (!validateCO.validate()) {

            validateCO.errors.allErrors.each {
                println it
            }
        }

        def email1 = validateCO.email1
        def email2 = validateCO.email2
        def email3 = validateCO.email3

        asynchronousMailService.sendAsynchronousMail {

            to "${email1}", "${email2}", "${email3}"
            subject "Hello. This is first Mail (Test)"
            html "<b>Hello !! You have been invited to checkout these topics ${topicsList}</b>"
        }
    }

    def sendMailReminder() {

        List<User> users = User.list()

        users.each {User user ->

            List<Subscription> subscriptions = Subscription.findAllBySubscriberAndSeriousness(user, Seriousness.SERIOUS)

            List<Topic> topics = subscriptions*.topic

            def readingItemList = topics ? ReadingItem.createCriteria().list {

                eq('user', user)
                'resourceItem' {

                    inList('topic', topics)
                }

                eq('isRead', false)
                maxResults 10
            } : []

            def readingItems = readingItemList.groupBy {it.resourceItem.topic.name}
            sendMailReminderOfUnreadItems(readingItems, user)
        }
    }

    def sendMailReminderOfUnreadItems(def readingItems, User user) {

        asynchronousMailService.sendAsynchronousMail {

            to "${user.email}"
            subject "Hello. This is first Mail (Test)"
            html "The Unread Resources are :${groovyPageRenderer.render(template: '/topic/unreadItems', model: [unreadItemsList: readingItems])}"
        }
    }

    def sendReminderAccordingToDate() {

        List<User> users = User.list()

        users.each {User user ->

            List<Subscription> subscriptions = Subscription.findAllBySubscriberAndSeriousness(user, Seriousness.VERY_SERIOUS)

            List<Topic> topics = subscriptions*.topic

            def readingItemList = topics ? ReadingItem.createCriteria().list {

                eq('user', user)
                'resourceItem' {

                    inList('topic', topics)
                    gt('dateCreated', new Date() - 2)
                }

                eq('isRead', false)
                maxResults 10
            } : []
            def readingItems = readingItemList.groupBy {it.resourceItem.topic.name}
            sendMailAsDate(readingItems, user)
        }
    }

    def sendMailAsDate(def readingItems, User user) {

        asynchronousMailService.sendAsynchronousMail {

            to "${user.email}"
            subject "Hello. This is first Mail (Test)"
            html "The Unread Resources are :${groovyPageRenderer.render(template: '/topic/unreadItemsByDate', model: [unreadItemsList: readingItems])}"
        }
    }

}