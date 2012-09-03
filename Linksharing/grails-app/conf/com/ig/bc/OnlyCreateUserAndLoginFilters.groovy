package com.ig.bc

class OnlyCreateUserAndLoginFilters {

    def filters = {
        all(controller: 'login|user', action: 'index|register|saveUser|checkEmailAvailability|loginHandler', invert: true) {

            before = {

                if (!(session.userEmail)) {

                    flash.message = "Login First !!"
                    redirect(controller: 'login')
                    return false
                }
            }
        }
    }
}

