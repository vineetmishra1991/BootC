package com.ig.bc

class TopicInitService {

    def serviceMethod() {

    }

    def topicInit(){
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
}
