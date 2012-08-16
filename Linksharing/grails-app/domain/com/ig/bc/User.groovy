package com.ig.bc

class User {
    String firstname
    String lastname
    String address
    String password
    String email
    Date dateCreated
    Date lastUpdated
    Boolean sex

    static hasMany = [subscriptions:Subscription,topics:Topic]



    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        email(email: true,nullable: false,unique: true)

         }

    static transients = ['fullName']

    String getFullName() {

        return "$firstname $lastname"
    }
}