package com.ig.bc


class UtilController {

    def index() { }

    def create()
    {
        User usr1=new User(firstname: 'vineet',lastname: 'mishra',address: 'pvihar',password: 'vineet',email: 'vnt.mshra@gmail.com',male: true)
        User usr2=new User(firstname: 'john',lastname: 'saxena',address: 'pvihardd',password: 'john',email: 'john.saxena@gmail.com',male: true)
        User usr3=new User(firstname: 'Admin',lastname: 'Company',address: 'noida',password: 'admin',email: 'admin@intelligrape.com',male: true)
        usr1.save(failOnError: true)
        usr2.save(failOnError: true)
        usr3.save(failOnError: true)

        usr1.addToTopics(new Topic(name: 'Grails', visibility: Visibility.PUBLIC,owner: usr1)).save(failOnError: true,flush: true)

        usr2.addToTopics(new Topic(name: 'Groovy',visibility:Visibility.PUBLIC,owner: usr2)).save(failOnError: true,flush: true)

        usr1.addToSubscriptions(new Subscription(seriousness: Seriousness.SERIOUS,topic:Topic.findByOwner(usr1))).save(failOnError: true,flush: true)

        usr2.addToSubscriptions(new Subscription(seriousness: Seriousness.VERY_SERIOUS,topic: Topic.findByOwner(usr2))).save(failOnError: true,flush: true)



       def top=Topic.findById(1)

        top.addToResources(new Linkresource(title: 'first url',summary: 'informative one',url: 'http://www.google.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'second url',summary: 'informative one second',url: 'http://www.facebook.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'third url',summary: 'informative one third',url: 'http://www.gmail.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'fourth url',summary: 'informative one fourth',url: 'http://www.youtube.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'fifth url',summary: 'informative one fifth',url: 'http://www.twitter.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'sixth url',summary: 'informative one sixth',url: 'http://www.yahoo.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'seventh url',summary: 'informative one seventh',url: 'http://www.mts.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'eight url',summary: 'informative one eight',url: 'http://www.airtel.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'ninth url',summary: 'informative one ninth',url: 'http://www.intelligrape.com')).save(failOnError: true,flush: true)
        top.addToResources(new Linkresource(title: 'tenth url',summary: 'informative one tenth',url: 'http://www.linkedin.com')).save(failOnError: true,flush: true)

        def top2=Topic.findById(2)
        top2.addToResources(new Linkresource(title: 'first',summary: 'informative one url',url: 'http://www.google1.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'second ',summary: 'informative one second url',url: 'http://www.facebook2.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'third',summary: 'informative one third url',url: 'http://www.gmail3.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'fourth',summary: 'informative one fourth url',url: 'http://www.youtube45.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'fifth',summary: 'informative one fifth url',url: 'http://www.twitter6.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'sixth ',summary: 'informative one sixth url',url: 'http://www.yahoo7.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'seventh ',summary: 'informative one seventh url',url: 'http://www.mts8.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'eight',summary: 'informative one eight url',url: 'http://www.airte9l.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'ninth',summary: 'informative one ninth url',url: 'http://www.intelligrap3e.com')).save(failOnError: true,flush: true)
        top2.addToResources(new Linkresource(title: 'tenth',summary: 'informative one tenth url',url: 'http://www.linke2din.com')).save(failOnError: true,flush: true)


        usr1.subscriptions.each {Subscription subscription->
            subscription.topic.resources.each { Resource resource ->
                usr1.addToReadingitems(new Readingitem(isfavorite: false,isread: false,user:usr1, resource:resource)).save(failOnError: true,flush: true)
            }

        }

        usr2.subscriptions.each {Subscription subscription->
            subscription.topic.resources.each { Resource resource ->
                usr2.addToReadingitems(new Readingitem(isfavorite: false,isread: false,user:usr2, resource:resource)).save(failOnError: true,flush: true)
            }

        }
//
// Resource.list().each {

//        usr1.addToReadingitems(isfavorite: false,isread: false, user: usr1, resource: it).save(failOnError: true,flush: true)

//        }




//        Resource.list().each {

//            usr2.addToReadingitems(isfavorite: false,isread: false, user: usr1, resource: it).save(failOnError: true,flush: true)

//        }


        usr1.getReadingitems().each {

            if(it.id<4)
            {
              it.isread=true
            }

        }
           println "user one has following unread resources"

         usr1.getReadingitems().each{

             if(it.isread==false)
             {
                 Linkresource lr=(Linkresource)it.resource
                  println lr.url
             }

         }



    }
}