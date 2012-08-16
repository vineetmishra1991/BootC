package com.ig.bc

abstract class Resource {

    Date dateCreated
    Date lastUpdated

    String title
    String summary

    static hasMany = [readingitems:Readingitem]

    static constraints = {
        summary(maxSize: 1024)
        }
}
