package com.ig.bc


class UtilController {

    def index() { }

    def create()
    {
        User usr1=new User(firstname: 'vineet',lastname: 'mishra',address: 'pvihar',password: 'vineet',email: 'vnt.mshra@gmail.com',male: true)
        User usr2=new User(firstname: 'john',lastname: 'saxena',address: 'pvihardd',password: 'john',email: 'john.saxena@gmail.com',male: true)
        usr1.save(failOnError: true)
        usr2.save(failOnError: true)

        usr1.addToTopics(new Topic(name: 'Grails', visibility: Visibility.PUBLIC,owner: usr1)).save(failOnError: true,flush: true)

        usr2.addToTopics(new Topic(name: 'Groovy',visibility:Visibility.PUBLIC,owner: usr2)).save(failOnError: true,flush: true)

        usr1.addToSubscriptions(new Subscription(seriousness: Seriousness.SERIOUS,topic:Topic.findByOwner(usr1))).save(failOnError: true,flush: true)

        usr2.addToSubscriptions(new Subscription(seriousness: Seriousness.VERY_SERIOUS,topic: Topic.findByOwner(usr2))).save(failOnError: true,flush: true)


//          Topic t=new Topic()
//        t.addToResources()
    }
}
