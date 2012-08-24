package com.ig.bc

class SetResourceToTopicService {

    def serviceMethod() {

    }

    def setResourcetotopic(){

        Topic.list().each{topic->

            10.times {
                topic.addToResources(new Linkresource(title: "first${it}", summary: "informative one url${it}", url: "http://www.google1${it}.com")).save(failOnError: true, flush: true)
            }
        }
    }
}
