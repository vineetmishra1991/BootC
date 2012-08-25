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

    static hasMany = [subscriptions: Subscription, topics: Topic, readingitems: Readingitem]

    static transients = ['fullName','confirmPassword']

    String getFullName() {

        return "$firstname $lastname"
    }

//   topic is a set which contains object of type Topic, set can be explicitly converted to a list


    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        email(email: true, nullable: false, unique: true)
        confirmPassword(bindable: true)
        password(validator: {currentPassword, obj ->
//            println "${obj.confirmPassword} >>> ${obj.password}"
            if(currentPassword != obj.confirmPassword){

                return false
            }

        })


    }
}
