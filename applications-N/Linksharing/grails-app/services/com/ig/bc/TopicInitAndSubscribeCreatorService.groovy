package com.ig.bc

class TopicInitAndSubscribeCreatorService {

    def serviceMethod() {

    }

    def topicInit() {
        List<Topic> topics = [new Topic(name: 'Grails', visibility: Visibility.PUBLIC),
                new Topic(name: 'Groovy', visibility: Visibility.PUBLIC),
                new Topic(name: 'Linux', visibility: Visibility.PUBLIC),
                new Topic(name: 'Git', visibility: Visibility.PUBLIC),
                new Topic(name: 'GORM', visibility: Visibility.PUBLIC)]

        User.findAllByEmailNotEqual('admin@intelligrape.com').eachWithIndex {user, idx ->
            println "adding topic to user:${user.email}"
            user.addToTopics(topics[idx]).save(failOnError: true, flush: true)
        }
    }

    def subscriberInit() {

        User user1 = User.findByFirstname('vineet')
        User user2 = User.findByFirstname('john')
        User user3 = User.findByFirstname('Ashish')
        User user4 = User.findByFirstname('Ron')
        User user5 = User.findByFirstname('harry')


        println Topic.list()
        List<Subscription> subscriptions = [new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user1)),
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user2)),
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user3)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user4)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user5)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user2))]


        User.list().eachWithIndex {user, idx ->
            user.addToSubscriptions(subscriptions[idx]).save(failOnError: true, flush: true)
        }
    }

}
