package com.ig.bc

class SubscriptionService {

    def serviceMethod() {

    }
    def subscriberInit(){

        User user1=User.findByFirstname('vineet')
        User user2=User.findByFirstname('john')
        User user3=User.findByFirstname('Ashish')
        User user4=User.findByFirstname('Ron')
        User user5=User.findByFirstname('harry')


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

    def addRandomSubscribersToTopic(){

        List<Topic> topic=Topic.list()
        topic.each {topicfind->
            List<User> user=User.list()
            User userDelete=topicfind.owner
            user = user-userDelete
            Collections.shuffle(user)
            user.first().addToSubscriptions(new Subscription(topic: topicfind,seriousness: Seriousness.SERIOUS )).save(failOnError: true, flush: true)
            user.last().addToSubscriptions(new Subscription(topic: topicfind,seriousness: Seriousness.VERY_SERIOUS)).save(failOnError: true, flush: true)
        }
    }

    def setReadingitemofuser(){

        List<User> users = User.list()
        users.each {User user ->
            user.subscriptions.each {Subscription subscription ->
                subscription.topic.resources.each { Resource resource ->
                    user.addToReadingitems(new Readingitem(isfavorite: false, isread: false, user: user, resource: resource)).save(failOnError: true, flush: true)
                }

            }
        }
    }

}
