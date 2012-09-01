package com.ig.bc

class ResourceAddToTopicService {

    def serviceMethod() {

    }
    //TODO ADD TO bootstrap service
    def setLinkResourceToTopic() {

        Topic.list().each {topic ->
            User.list().each {user ->
                10.times {
                    topic.addToResources(new LinkResource(title: "first${it}", summary: "informative one url${it}", url: "http://www.google1${it}.com", owner: user)).save(failOnError: true, flush: true)
                }
            }
        }
    }
}

