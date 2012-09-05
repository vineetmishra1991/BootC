package com.ig.bc

class Subscription {

    Date dateCreated
    Date lastUpdated
    Seriousness seriousness

    static belongsTo = [subscriber: User, topic: Topic]

    static constraints = {
        topic(unique: 'subscriber')
    }
}
