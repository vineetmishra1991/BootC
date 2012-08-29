package com.ig.bc

class SubscriptionService {

    def serviceMethod() {

    }

    def addRandomSubscribersToTopic() {

        List<Topic> topic = Topic.list()
        topic.each {topicfind ->
            List<User> user = User.list()
            User userDelete = topicfind.owner
            user = user - userDelete
            Collections.shuffle(user)
            user.first().addToSubscriptions(new Subscription(topic: topicfind, seriousness: Seriousness.SERIOUS)).save(failOnError: true, flush: true)
            user.last().addToSubscriptions(new Subscription(topic: topicfind, seriousness: Seriousness.VERY_SERIOUS)).save(failOnError: true, flush: true)
        }
    }

    def setReadingitemofuser() {

        List<User> users = User.list()
        users.each {User user ->
            user.subscriptions.each {Subscription subscription ->
                subscription.topic.resources.each { Resource resource ->
                    user.addToReadingitems(new ReadingItem(isFavourite: false, isRead: false, user: user, resourceItem: resource)).save(failOnError: true, flush: true)
                }


            }
        }
        throw new RuntimeException()
    }

}
