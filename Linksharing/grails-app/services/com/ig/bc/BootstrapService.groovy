package com.ig.bc

class BootstrapService {

    def serviceMethod() {

    }

    def initializeData() {

        userInit()
        topicInit()
        subscriberInit()
        setLinkResourceToTopic()
        addRandomSubscribersToTopic()
        setReadingItemOfUser()
        setReadingItemsTrue()
    }

    def userInit() {

        User usr1 = new User(firstname: 'vineet', lastname: 'mishra', address: 'pvihar', password: 'vineet', confirmPassword: 'vineet', email: 'vnt.mshra@gmail.com', dateOfBirth: new Date(), male: true)
        User usr2 = new User(firstname: 'john', lastname: 'saxena', address: 'pvihardd', password: 'john', confirmPassword: 'john', email: 'john.saxena@gmail.com', male: true, dateOfBirth: new Date())
        User usr3 = new User(firstname: 'Admin', lastname: 'company', address: 'noida', password: 'admin', confirmPassword: 'admin', email: 'admin@intelligrape.com', male: true, dateOfBirth: new Date())
        User usr4 = new User(firstname: 'Ashish', lastname: 'mishra', address: 'delhi', password: 'ash', confirmPassword: 'ash', email: 'ash@gmail.com', male: true, dateOfBirth: new Date())
        User usr5 = new User(firstname: 'Ron', lastname: 'sharma', address: 'mumbai', password: 'ronw', confirmPassword: 'ronw', email: 'ron@gmail.com', male: true, dateOfBirth: new Date())
        User usr6 = new User(firstname: 'harry', lastname: 'singh', address: 'delhi', password: 'harryp', confirmPassword: 'harryp', email: 'harry@gmail.com', male: true, dateOfBirth: new Date())
        User usr7 = new User(firstname: 'harryp', lastname: 'singha', address: 'delhi', password: 'harryp', confirmPassword: 'harryq', email: 'harry1@gmail.com', male: true, dateOfBirth: new Date())
        User usr8 = new User(firstname: 'harryq', lastname: 'singhb', address: 'assam', password: 'harryp', confirmPassword: 'harryq', email: 'harry2@gmail.com', male: true, dateOfBirth: new Date())
        User usr9 = new User(firstname: 'harryr', lastname: 'singhc', address: 'punjabb', password: 'harryp', confirmPassword: 'harryr', email: 'harry3@gmail.com', male: true, dateOfBirth: new Date())
        User usr10 = new User(firstname: 'harrys', lastname: 'singhd', address: 'delhi', password: 'harryp', confirmPassword: 'harrys', email: 'harry4@gmail.com', male: true, dateOfBirth: new Date())


        usr1.save(failOnError: true, flush: true)
        usr2.save(failOnError: true, flush: true)
        usr3.save(failOnError: true, flush: true)
        usr4.save(failOnError: true, flush: true)
        usr5.save(failOnError: true, flush: true)
        usr6.save(failOnError: true, flush: true)
        usr7.save(failOnError: true, flush: true)
        usr8.save(failOnError: true, flush: true)
        usr9.save(failOnError: true, flush: true)
        usr10.save(failOnError: true, flush: true)
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

    void setLinkResourceToTopic() {

        Topic.list().each {topic ->
            User.list().each {user ->
                10.times {
                    topic.addToResources(new LinkResource(title: "first${it}", summary: "informative one url${it}", url: "http://www.google1${it}.com", owner: user)).save(failOnError: true, flush: true)
                }
            }
        }
    }

    void addRandomSubscribersToTopic() {

        List<Topic> topic = Topic.list()

        topic.each {topicFind ->
            List<User> user = User.list()
            User userDelete = topicFind.owner

            user = user - userDelete

            Collections.shuffle(user)

            User userFirst = user.first()
            User userSecond = user.last()

            if (!(Subscription.findBySubscriberAndTopic(userFirst, topicFind))) {
                user.first().addToSubscriptions(new Subscription(topic: topicFind, seriousness: Seriousness.SERIOUS)).save(failOnError: true, flush: true)

            }

            if (!(Subscription.findBySubscriberAndTopic(userSecond, topicFind))) {
                user.last().addToSubscriptions(new Subscription(topic: topicFind, seriousness: Seriousness.VERY_SERIOUS)).save(failOnError: true, flush: true)

            }
        }
    }

    void setReadingItemOfUser() {

        List<User> users = User.list()
        users.each {User user ->
            user.subscriptions.each {Subscription subscription ->
                subscription.topic.resources.each { Resource resource ->
                    user.addToReadingitems(new ReadingItem(isFavourite: false, isRead: false, user: user, resourceItem: resource)).save(failOnError: true, flush: true)
                }
            }
        }
    }

    void setReadingItemsTrue() {

        User user = User.get(1)
        user.getReadingitems().each {

            if (it.id < 4) {
                it.isRead = true
            }

        }
    }
}
