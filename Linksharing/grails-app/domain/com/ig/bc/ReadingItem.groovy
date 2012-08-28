package com.ig.bc

class ReadingItem {

    Boolean isFavourite
    Boolean isRead

    static belongsTo = [resource: Resource, user: User]


    static constraints = {
    }

}
