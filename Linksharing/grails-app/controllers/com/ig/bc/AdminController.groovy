package com.ig.bc

class AdminController {

    def index() { }

    def beforeInterceptor = {
        User user = User.findByEmail(session.userEmail);
        if (!user.admin) {
            render "Access Denied"
            return false
        }
    }

    def stats() {

        Integer count = User.count
        List<String> subscriptionDetails = []
        User.list().each {User user ->
            subscriptionDetails.add("User name : ${user.firstname}, Subscriptions : ${user.subscriptions.size()}")
        }
        render(view: "stats", model: [count: count, subscriptionDetails: subscriptionDetails])

    }

    def makeAdmin() {
        List<User> userInstanceList = User.list()
        render(view: "makeAdmin", model: [userInstanceList: userInstanceList])
    }

    def toggleAdmin() {
        User user = params.id ? User.get(params.id) : null
        if (user && user.email != "admin@intelligrape.com") {
            user.admin = !user.admin
        }
        user.save(flush: true)
        render user?.admin ? 'Admin' : 'Make Admin'
    }

}

