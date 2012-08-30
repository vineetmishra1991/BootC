package com.ig.bc

class ResourceAddToTopicService {

    def serviceMethod() {

    }
     //TODO ADD TO bootstrap service
    def setLinkResourcetotopic() {

        Topic.list().each {topic ->

            10.times {
                topic.addToResources(new LinkResource(title: "first${it}", summary: "informative one url${it}", url: "http://www.google1${it}.com")).save(failOnError: true, flush: true)

            }
        }
    }
}

