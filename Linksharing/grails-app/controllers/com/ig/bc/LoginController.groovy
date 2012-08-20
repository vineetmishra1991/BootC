package com.ig.bc

class LoginController {

    def index() {
            redirect(uri: '/pogin.html')
    }

    def loginHandler(){
           String email=params.t1
           String password=params.t2
        if (email && password)  {
            if (User.countByEmailAndPassword(email,password)){
               session.userEmail=email
               session.password=password
                redirect(controller: 'user',action: 'dashboard')

                return
            }
        }
        redirect(action: 'index')
    }

    def logout() {

        session.invalidate()
        redirect(action: 'index')
    }

}
