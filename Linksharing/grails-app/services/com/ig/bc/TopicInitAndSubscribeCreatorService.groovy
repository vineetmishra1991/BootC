package com.ig.bc

class TopicInitAndSubscribeCreatorService {

    def serviceMethod() {

    }

    def topicInit() {
        List<Topic> topics = [new Topic(name: 'Grails', visibility: Visibility.PUBLIC),
                new Topic(name: 'Groovy', visibility: Visibility.PUBLIC),
                new Topic(name: 'Linux', visibility: Visibility.PUBLIC),
                new Topic(name: 'Git', visibility: Visibility.PUBLIC),
                new Topic(name: 'GORM', visibility: Visibility.PUBLIC),
                new Topic(name: 'SCRUM', visibility: Visibility.PUBLIC),
                new Topic(name: 'XP', visibility: Visibility.PUBLIC),
                new Topic(name: 'AGILE', visibility: Visibility.PUBLIC),
                new Topic(name: 'COLLECTIONS', visibility: Visibility.PUBLIC),
                new Topic(name: 'JQUERY', visibility: Visibility.PUBLIC)]

        User.findAllByEmailNotEqual('admin@intelligrape.com').eachWithIndex {user, idx ->
            user.addToTopics(topics[idx]).save(failOnError: true, flush: true)
        }
    }

    def subscriberInit() {

        User user1 = User.findByFirstname('vineet')
        User user2 = User.findByFirstname('john')
        User user3 = User.findByFirstname('Ashish')
        User user4 = User.findByFirstname('Ron')
        User user5 = User.findByFirstname('harry')
        User user6 = User.findByFirstname('harryp')
        User user7 = User.findByFirstname('harryq')
        User user8 = User.findByFirstname('harryr')
        User user9 = User.findByFirstname('harrys')

        List<Subscription> subscriptions = [new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user1)),
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user2)),
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user3)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user4)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user5)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user2)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user6)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user7)),
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user8)),
                new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user9)),]


        User.list().eachWithIndex {user, idx ->
            user.addToSubscriptions(subscriptions[idx]).save(failOnError: true, flush: true)
        }
    }

}
