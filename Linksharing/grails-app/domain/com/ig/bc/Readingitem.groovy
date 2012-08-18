package com.ig.bc

class Readingitem {

    Boolean isfavorite
    Boolean isread
    User usr
    Resource res

    static belongsTo = [Resource]

    static constraints = {
    }
}
