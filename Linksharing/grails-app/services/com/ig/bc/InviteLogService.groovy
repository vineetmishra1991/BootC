package com.ig.bc

class InviteLogService {
    static transactional = false

    def serviceMethod() {

    }

    def commandObjectBinding(VaildatorCO validateCO) {

        if (!validateCO.validate()) {

            validateCO.errors.allErrors.each {
                println it
            }
        }
    }
}
