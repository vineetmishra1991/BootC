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
        }
        if (!(controllerName == 'user' && actionName == 'dashboard')) {
            flash.message = "Username And Password Doesn't Exist ! Please Try Again !!"
        }
        redirect(controller: controllerName, action: actionName)
    }

    def logout() {

        session.invalidate()
        flash.message = "Thanks For Visiting The Site!!"
        redirect(action: 'index')
    }
}
