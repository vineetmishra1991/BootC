package com.ig.bc

class BootstrapService {

    def userInitService
    def topicInitService
    def setResourceToTopicService
    def subscriptionService
    def setReadingItemTrueRandomAndPrintUnreadItemsService

    def serviceMethod() {

    }

    def initializeData() {

        userInitService.userInit()
        topicInitService.topicInit()
        setResourceToTopicService.setResourcetotopic()
        subscriptionService.subscriberInit()
        subscriptionService.addRandomSubscribersToTopic()
        subscriptionService.setReadingitemofuser()
        setReadingItemTrueRandomAndPrintUnreadItemsService.setReadingitemstruerandom()
        setReadingItemTrueRandomAndPrintUnreadItemsService.unreadItemsofuser()

    }
}
