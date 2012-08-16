package com.ig.bc

class Subscription {

    Date dateCreated
    Date lastUpdated

    User subscriber
    Seriousness seriousness
    Topic topic


    static constraints = {
        topic(unique: 'subscriber')
    }
}
