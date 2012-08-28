package com.ig.bc

class User {
    String firstname
    String lastname
    String address
    String password
    String confirmPassword
    String email
    Date dateCreated
    Date lastUpdated
    Boolean male

    static hasMany = [subscriptions: Subscription, topics: Topic, readingitems: ReadingItem]

    static transients = ['fullName', 'confirmPassword']

    String getFullName() {
        return "$firstname $lastname"
    }

    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        email(email: true, nullable: false, unique: true)
        confirmPassword(bindable: true)
        password(validator: {currentPassword, obj ->
            if (currentPassword != obj.confirmPassword) {
                return false
            }
        })
    }
}
