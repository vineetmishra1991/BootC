package com.ig.bc

class InviteLogService {
    static transactional = false
    def mailService
    def asynchronousMailService

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

            List<Readingitem> readingitemList = []
            user.subscriptions.each {Subscription subscription ->
                if (subscription.seriousness == Seriousness.SERIOUS) {
                    subscription.topic.resources.each {Resource resource ->

                        resource.readingitems.each {Readingitem readingitem ->

                            if (!readingitem.isread) {

                                readingitemList.add(readingitem)

                            }

                        }

                    }
                }

            }

            asynchronousMailService.sendAsynchronousMail {

                to "${user.email}"
                subject "Hello. This is first Mail (Test)"
                html "<b>${readingitemList*.resource.url.join(',')}</b>"
            }
            println "mail sent"

        }

    }

}




