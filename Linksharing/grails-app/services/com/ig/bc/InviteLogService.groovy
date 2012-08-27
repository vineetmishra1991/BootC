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


}

