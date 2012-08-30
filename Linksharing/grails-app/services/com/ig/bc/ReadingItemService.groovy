package com.ig.bc

class ReadingItemService {

    def serviceMethod() {

    }
//TODO MOVE TO BOOTSTRAP AND RENAME FUNCTION
    def setReadingitemstruerandom() {

        User user = User.get(1)
        user.getReadingitems().each {

            if (it.id < 4) {
                it.isRead = true
            }

        }
    }
}
