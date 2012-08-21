package com.ig.bc

class LoginController {

    def index() {
            redirect(uri: '/pogin.html')
    }

    def loginHandler(){
           String email=params.t1
           String password=params.t2
        String controllerName = "login"
        String actionName = "index"
        if (email && password)  {
            if (User.countByEmailAndPassword(email,password)){
               session.userEmail=email
                controllerName = 'user'
                actionName = 'dashboard'
            }
//            else{ flash.message="Not Exist !!"}

        }
        redirect(controller: controllerName,action: actionName)

    }

    def logout() {

        session.invalidate()
        redirect(action: 'index')
    }

}
