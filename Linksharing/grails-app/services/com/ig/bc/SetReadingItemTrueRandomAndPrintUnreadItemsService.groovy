package com.ig.bc

class SetReadingItemTrueRandomAndPrintUnreadItemsService {

    def serviceMethod() {

    }

    def setReadingitemstruerandom(){

        User user = User.get(1)
        user.getReadingitems().each {

            if (it.id < 4) {
                it.isread = true
            }

        }
    }

    def unreadItemsofuser() {

        println "user one has following unread resources"
        User user = User.get(1)
        user.getReadingitems().each {

            if (!it.isread) {
                Linkresource lr = (Linkresource) it.resource
                println lr.url
            }

        }
    }

}
