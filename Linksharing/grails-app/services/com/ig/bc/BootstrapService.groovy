package com.ig.bc

class BootstrapService {

    def userInitService
    def topicInitAndSubscribeCreatorService
    def resourceToTopicService
    def subscriptionService
    def readingItemTrueRandomAndPrintUnreadItemsService

    def serviceMethod() {

    }

    def initializeData() {

        userInitService.userInit()
        topicInitAndSubscribeCreatorService.topicInit()
        topicInitAndSubscribeCreatorService.subscriberInit()
        resourceToTopicService.setLinkResourcetotopic()
        subscriptionService.addRandomSubscribersToTopic()
        subscriptionService.setReadingitemofuser()
        readingItemTrueRandomAndPrintUnreadItemsService.setReadingitemstruerandom()
        readingItemTrueRandomAndPrintUnreadItemsService.unreadItemsofuser()

    }
}
