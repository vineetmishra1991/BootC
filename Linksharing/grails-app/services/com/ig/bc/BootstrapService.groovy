package com.ig.bc

class BootstrapService {

    def userInitService
    def topicInitAndSubscribeCreatorService
    def setResourceToTopicService
    def subscriptionService
    def setReadingItemTrueRandomAndPrintUnreadItemsService

    def serviceMethod() {

    }

    def initializeData() {

        userInitService.userInit()
        topicInitAndSubscribeCreatorService.topicInit()
        topicInitAndSubscribeCreatorService.subscriberInit()
        setResourceToTopicService.setResourcetotopic()
        subscriptionService.addRandomSubscribersToTopic()
        subscriptionService.setReadingitemofuser()
        setReadingItemTrueRandomAndPrintUnreadItemsService.setReadingitemstruerandom()
        setReadingItemTrueRandomAndPrintUnreadItemsService.unreadItemsofuser()

    }
}
