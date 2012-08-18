package com.ig.bc

class Topic {

        String name
        User owner
        Visibility visibility
    static hasMany = [subscriptions:Subscription,resources:Resource]
    static belongsTo = [owner:User]

    static constraints = {
        name(blank: false,unique: true)
    }
}
