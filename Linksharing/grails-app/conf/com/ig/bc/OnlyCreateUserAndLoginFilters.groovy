package com.ig.bc

class OnlyCreateUserAndLoginFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if (!session.userEmail && !controllerName.equals('login') && !(controllerName.equals('user') && actionName.equals('register')) && !(controllerName.equals
                        ('user') && actionName.equals('saveUser'))&&!(controllerName.equals('user')&&actionName.equals('checkEmailAvailability'))) {
                    flash.message = "Login First !!"
                    redirect(controller: 'login')
                    return false
                }
            }
        }
    }
}
