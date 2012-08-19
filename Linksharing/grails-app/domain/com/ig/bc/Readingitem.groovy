package com.ig.bc

class Readingitem {

    Boolean isfavorite
    Boolean isread
    User user
    Resource resource
    static belongsTo = [resource:Resource,user:User]

    static constraints = {
    }

}
