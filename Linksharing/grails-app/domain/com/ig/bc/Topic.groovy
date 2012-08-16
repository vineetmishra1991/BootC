package com.ig.bc

class Topic {

        String tname
        User owner
        Visibility visibility
    static hasMany = [subscriptions:Subscription,resources:Resource]

    static constraints = {
        tname(blank: false,unique: true)
    }
}
