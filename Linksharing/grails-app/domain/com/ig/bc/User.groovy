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
    Date dateOfBirth
    Boolean male
    Boolean admin

    static hasMany = [subscriptions: Subscription, topics: Topic, readingitems: ReadingItem]

    static transients = ['fullName', 'confirmPassword']

    String getFullName() {
        return "$firstname $lastname"
    }

    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        email(email: true, nullable: false, unique: true)
        admin(nullable: true)
        confirmPassword(bindable: true)


        password(validator: {val, obj ->
            if (!obj.id) {
                if (val != obj.confirmPassword) {
                    return false
                }
            }
            else return true
        })
    }
}
