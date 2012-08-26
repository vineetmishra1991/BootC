package com.ig.bc

class Topic {

    String name
    Visibility visibility
    static hasMany = [subscriptions: Subscription, resources: Resource]
    static belongsTo = [owner: User]

    String toString(){
        return name
    }
    static constraints = {
        name(blank: false, unique: true)
    }
}
