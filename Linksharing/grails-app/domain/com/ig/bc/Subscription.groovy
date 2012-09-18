package com.ig.bc

class Subscription {

    Date dateCreated
    Date lastUpdated
    Seriousness seriousness
    Boolean isLike

    static belongsTo = [subscriber: User, topic: Topic]

    static constraints = {
        topic(unique: 'subscriber')
        isLike(nullable: true, blank: true)
    }
}
