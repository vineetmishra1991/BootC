package com.ig.bc

class OnlyCreateUserAndLoginFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if (!session.userEmail && !controllerName.equals('login')&& !(controllerName.equals('user')&&actionName.equals('create'))) {

                    flash.message="Login First !!"
                    redirect(controller: 'login')
                    return false
                }

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
