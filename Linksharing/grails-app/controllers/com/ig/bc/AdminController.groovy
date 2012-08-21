package com.ig.bc

class AdminController {

    def index() { }

    def beforeInterceptor = {

        if(session.userEmail!="admin@intelligrape.com") {
            render "Access Denied"
            return false
        }
    }

    def stats(){

        Integer count= User.count
        List<String> subscriptionDetails=[]
        User.list().each {User user->
           subscriptionDetails.add("User name : ${user.firstname}, Subscriptions : ${user.subscriptions.size()}")
        }

        render (view:"stats",model: [count:count,subscriptionDetails:subscriptionDetails])

    }

}

