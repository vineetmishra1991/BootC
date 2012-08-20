package com.ig.bc

abstract class Resource {

    Date dateCreated
    Date lastUpdated

    String title
    String summary

   static belongsTo = [topic:Topic]

    static constraints = {
        summary(maxSize: 1024)
        }


}
