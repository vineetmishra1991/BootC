package com.ig.bc

class EmailInviteService {
    static transactional = false
    def mailService
    def asynchronousMailService
    def groovyPageRenderer

    def serviceMethod() {

    }

    def sendInviteMail(VaildatorCO validateCO) {

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
            html '<b>Hello</b>'
        }

    }

    def sendMailReminder() {

        List<User> userList = User.list()

        userList.each {User user ->

            List<ReadingItem> readingitemList = []
            user.subscriptions.each {Subscription subscription ->
                if (subscription.seriousness == Seriousness.SERIOUS) {
                    subscription.topic.resources.each {Resource resource ->

                        resource.readingitems.each {ReadingItem readingitem ->

                            if (!readingitem.isRead) {

                                readingitemList.add(readingitem)

                            }

                        }
                    }
                }

            }
            def readingItems = readingitemList.groupBy {it.resource.topic.name}
//            println readingItems.values()
            asynchronousMailService.sendAsynchronousMail {

                to "${user.email}"
                subject "Hello. This is first Mail (Test)"
                html "The Unread Resources are :${groovyPageRenderer.render(template: '/topic/unreadItems', model: [unreadItemsList: readingItems])}"
            }
            println "mail sent"

        }

    }

    def sendReminderAccordingToDate() {

        List<User> userList = User.list()
        Date date = new Date() - 2
        userList.each {User user ->

            List<ReadingItem> readingitemList = []
            user.subscriptions.each {Subscription subscription ->
                if (subscription.seriousness == Seriousness.VERY_SERIOUS) {
                    subscription.topic.resources.each {Resource resource ->
                        if (resource.dateCreated > date) {
                            resource.readingitems.each {ReadingItem readingitem ->

                                if (!readingitem.isRead) {

                                    readingitemList.add(readingitem)

                                }

                            }
                        }
                    }
                }

            }
            def readingItems = readingitemList.groupBy {it.resource.topic.name}
            asynchronousMailService.sendAsynchronousMail {

                to "${user.email}"
                subject "Hello. This is first Mail (Test)"
                html "The Unread Resources are :${groovyPageRenderer.render(template: '/topic/unreadItemsByDate', model: [unreadItemsList: readingItems])}"
            }
            println "mail sent"

        }

    }

}




