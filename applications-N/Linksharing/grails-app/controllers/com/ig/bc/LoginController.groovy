package com.ig.bc

class LoginController {

    def index() {

        if (session.userEmail) {
            redirect(controller: 'user', action: 'dashboard')
        }
        else {
            render(view: '/login')
        }

    }

    def loginHandler() {
        String email = params.t1
        String password = params.t2
        String controllerName = "login"
        String actionName = "index"
        if (email && password) {
            if (User.countByEmailAndPassword(email, password)) {
                session.userEmail = email
                controllerName = 'user'
                actionName = 'dashboard'
            }
//            else{ flash.message="Not Exist !!"}

        }
        redirect(controller: controllerName, action: actionName)

    }

    def logout() {

        session.invalidate()
        redirect(action: 'index')
    }

}
