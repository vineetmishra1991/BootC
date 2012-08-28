package com.ig.bc

class ReadingItemTrueRandomAndPrintUnreadItemsService {

    def serviceMethod() {

    }

    def setReadingItemsTrueRandom() {

        User user = User.get(1)
        user.getReadingitems().each {

            if (it.id < 4) {
                it.isRead = true
            }

        }
    }

    def unReadItemsOfUser() {

        println "user one has following unread resources"
        User user = User.get(1)
        user.getReadingitems().each {

            if (!it.isRead) {
                LinkResource lr = (LinkResource) it.resource
                println lr.url
            }

        }
    }

}
