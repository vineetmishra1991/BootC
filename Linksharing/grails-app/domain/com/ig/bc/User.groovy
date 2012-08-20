package com.ig.bc

class User {
    String firstname
    String lastname
    String address
    String password
    String email
    Date dateCreated
    Date lastUpdated
    Boolean male

    static hasMany = [subscriptions:Subscription,topics: Topic,readingitems:Readingitem]

//   topic is a set which contains object of type Topic, set can be explicitly converted to a list


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
