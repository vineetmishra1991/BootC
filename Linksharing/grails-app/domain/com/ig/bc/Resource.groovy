package com.ig.bc

abstract class Resource {

    Date dateCreated
    Date lastUpdated

    String title
    String summary

    static belongsTo = [topic: Topic]
    static hasMany = [readingitems: ReadingItem]

    static constraints = {
        summary(maxSize: 1024)
    }

    static mapping = {
        summary type: 'text'
        tablePerHierarchy false
    }

}
