package com.ig.bc

class ReadingItem {

    Boolean isFavourite
    Boolean isRead

    static belongsTo = [resourceItem: Resource, user: User]

    static constraints = {
    }
}
