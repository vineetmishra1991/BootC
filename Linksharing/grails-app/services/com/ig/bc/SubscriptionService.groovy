package com.ig.bc

class SubscriptionService {

    def serviceMethod() {

    }

    def addRandomSubscribersToTopic() {

        List<Topic> topic = Topic.list()
        topic.each {topicFind ->
            List<User> user = User.list()
            User userDelete = topicFind.owner
            user = user - userDelete
            Collections.shuffle(user)
            user.first().addToSubscriptions(new Subscription(topic: topicFind, seriousness: Seriousness.SERIOUS)).save(failOnError: true, flush: true)
            user.last().addToSubscriptions(new Subscription(topic: topicFind, seriousness: Seriousness.VERY_SERIOUS)).save(failOnError: true, flush: true)
        }
    }

    def setReadingItemOfUser() {

        List<User> users = User.list()
        users.each {User user ->
            user.subscriptions.each {Subscription subscription ->
                subscription.topic.resources.each { Resource resource ->
                    user.addToReadingitems(new ReadingItem(isFavourite: false, isRead: false, user: user, resource: resource)).save(failOnError: true, flush: true)
                }


            }
        }
    }

}
