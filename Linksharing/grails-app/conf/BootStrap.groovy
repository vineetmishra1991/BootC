import com.ig.bc.User
import com.ig.bc.Topic
import com.ig.bc.Visibility
import com.ig.bc.Subscription
import com.ig.bc.Seriousness
import com.ig.bc.Linkresource
import com.ig.bc.Resource
import com.ig.bc.Readingitem

class BootStrap {

                   def bootstrapService
    def init = { servletContext ->

        bootstrapService.initializeData()
    }
    def destroy = {

    }


//def userInit() {
//
//    User usr1 = new User(firstname: 'vineet', lastname: 'mishra', address: 'pvihar', password: 'vineet', confirmPassword: 'vineet', email: 'vnt.mshra@gmail.com', male: true)
//    User usr2 = new User(firstname: 'john', lastname: 'saxena', address: 'pvihardd', password: 'john', confirmPassword: 'john', email: 'john.saxena@gmail.com', male: true)
//    User usr3 = new User(firstname: 'Admin', lastname: 'company', address: 'noida', password: 'admin', confirmPassword: 'admin', email: 'admin@intelligrape.com', male: true)
//    User usr4 = new User(firstname: 'Ashish', lastname: 'mishra', address: 'delhi', password: 'ash', confirmPassword: 'ash', email: 'ash@gmail.com', male: true)
//    User usr5 = new User(firstname: 'Ron', lastname: 'sharma', address: 'mumbai', password: 'ronw', confirmPassword: 'ronw', email: 'ron@gmail.com', male: true)
//    User usr6 = new User(firstname: 'harry', lastname: 'singh', address: 'delhi', password: 'harryp', confirmPassword: 'harryp', email: 'harry@gmail.com', male: true)
//
//    usr1.save(failOnError: true)
//    usr2.save(failOnError: true)
//    usr3.save(failOnError: true)
//    usr4.save(failOnError: true)
//    usr5.save(failOnError: true)
//    usr6.save(failOnError: true)
//}
//
//def topicInit() {
//    List<Topic> topics = [new Topic(name: 'Grails', visibility: Visibility.PUBLIC),
//            new Topic(name: 'Groovy', visibility: Visibility.PUBLIC),
//            new Topic(name: 'Linux', visibility: Visibility.PUBLIC),
//            new Topic(name: 'Git', visibility: Visibility.PUBLIC),
//            new Topic(name: 'GORM', visibility: Visibility.PUBLIC)]
//
//    User.findAllByEmailNotEqual('admin@intelligrape.com').eachWithIndex {user, idx ->
//        println "adding topic to user:${user.email}"
//        user.addToTopics(topics[idx]).save(failOnError: true, flush: true)
//    }
//}
//
//def subscriberInit() {
//
//    User user1=User.findByFirstname('vineet')
//    User user2=User.findByFirstname('john')
//    User user3=User.findByFirstname('Ashish')
//    User user4=User.findByFirstname('Ron')
//    User user5=User.findByFirstname('harry')
//
//
//    println Topic.list()
//    List<Subscription> subscriptions = [new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user1)),
//            new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user2)),
//            new Subscription(seriousness: Seriousness.VERY_SERIOUS, topic: Topic.findByOwner(user3)),
//            new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user4)),
//            new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user5)),
//            new Subscription(seriousness: Seriousness.SERIOUS, topic: Topic.findByOwner(user2))]
//
//
//    User.list().eachWithIndex {user, idx ->
//        user.addToSubscriptions(subscriptions[idx]).save(failOnError: true, flush: true)
//    }
//}
//
//    def addRandomSubscribersToTopic(){
//        List<Topic> topic=Topic.list()
//        topic.each {topicfind->
//            List<User> user=User.list()
//            User userDelete=topicfind.owner
//            user = user-userDelete
//            Collections.shuffle(user)
//            user.first().addToSubscriptions(new Subscription(topic: topicfind,seriousness: Seriousness.SERIOUS )).save(failOnError: true, flush: true)
//            user.last().addToSubscriptions(new Subscription(topic: topicfind,seriousness: Seriousness.VERY_SERIOUS)).save(failOnError: true, flush: true)
//        }
//    }
//
//def setResourcetotopic() {
//
//
//    Topic.list().each{topic->
//
//        10.times {
//            topic.addToResources(new Linkresource(title: "first${it}", summary: "informative one url${it}", url: "http://www.google1${it}.com")).save(failOnError: true, flush: true)
//        }
//    }
//
//}
//
//def setReadingitemofuser() {
//
//    List<User> users = User.list()
//    users.each {User user ->
//        user.subscriptions.each {Subscription subscription ->
//            subscription.topic.resources.each { Resource resource ->
//                user.addToReadingitems(new Readingitem(isfavorite: false, isread: false, user: user, resource: resource)).save(failOnError: true, flush: true)
//            }
//
//        }
//    }
//}
//
//def setReadingitemstruerandom() {
//
//    User user = User.get(1)
//    user.getReadingitems().each {
//
//        if (it.id < 4) {
//            it.isread = true
//        }
//
//    }
//}
//
//def unreadItemsofuser() {
//
//    println "user one has following unread resources"
//    User user = User.get(1)
//    user.getReadingitems().each {
//
//        if (!it.isread) {
//            Linkresource lr = (Linkresource) it.resource
//            println lr.url
//        }
//
//    }
//
//  }

//  def addSubsberToTopicRandom(){
//
//      User.list().each {user->
//      Topic.findByOwnerNotEqual(user).each {topic->
//     topic.each {
//         Subscription subscription=new Subscription(subscriber: user,seriousness: Seriousness.SERIOUS )
//         it.addToSubscriptions(subscription)
//         it.save()
//     }
//      }
//    }
//
//  }

}
