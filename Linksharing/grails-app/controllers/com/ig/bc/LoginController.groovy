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
        String email = params.name
        String password = params.password
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
//        flash.message="Logged In Successfully !!"
        redirect(controller: controllerName, action: actionName)

    }

    def logout() {

        session.invalidate()
        redirect(action: 'index')
    }

}
