package com.ig.bc

class DocumentResourceService {

    def serviceMethod() {

    }

    def commandObjectBinding(DocumentResourceAdderCO documentResourceAdderCO, def path) {

        def id = documentResourceAdderCO.id
        def title = documentResourceAdderCO.title
        def summary = documentResourceAdderCO.summary
        def file = documentResourceAdderCO.myFile
        Topic topicNew = Topic.get(id)
        DocumentResource documentResource = new DocumentResource(title: title, summary: summary, topic: topicNew).save(flush: true, failOnError: true)
        def resourceId = documentResource.id
        file.transferTo(new File("${path}/${resourceId}"))
        documentResource.fileName = resourceId
        documentResource.contentType = file.contentType
        documentResource.save(flush: true, failOnError: true)
        topicNew.addToResources(documentResource).save(flush: true, failOnError: true)

    }
}
