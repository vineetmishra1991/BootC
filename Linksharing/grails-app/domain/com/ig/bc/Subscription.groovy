package com.ig.bc

class Subscription {

    Date dateCreated
    Date lastUpdated

    User subscriber
    Seriousness seriousness
    Topic topic

    static belongsTo = [subscriber:User,topic:Topic]

    static constraints = {
        topic(unique: 'subscriber')
    }
}
