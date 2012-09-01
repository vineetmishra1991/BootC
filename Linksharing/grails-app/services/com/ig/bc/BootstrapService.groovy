package com.ig.bc

class BootstrapService {

    def userInitService
    def topicInitAndSubscribeCreatorService
    def resourceAddToTopicService
    def subscriptionService
    def readingItemService

    def serviceMethod() {

    }

    def initializeData() {

        userInitService.userInit()
        topicInitAndSubscribeCreatorService.topicInit()
        topicInitAndSubscribeCreatorService.subscriberInit()
        resourceAddToTopicService.setLinkResourceToTopic()
        subscriptionService.addRandomSubscribersToTopic()
        subscriptionService.setReadingitemofuser()
        readingItemService.setReadingitemstruerandom()
    }
}
