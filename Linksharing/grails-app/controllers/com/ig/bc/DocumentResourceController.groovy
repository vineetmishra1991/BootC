package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class DocumentResourceController {
    def documentResourceService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [documentResourceInstanceList: DocumentResource.list(params), documentResourceInstanceTotal: DocumentResource.count()]
    }

    def create() {
        [documentResourceInstance: new DocumentResource(params)]
    }

    def save() {
        def documentResourceInstance = new DocumentResource(params)
        if (!documentResourceInstance.save(flush: true)) {
            render(view: "create", model: [documentResourceInstance: documentResourceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), documentResourceInstance.id])
        redirect(action: "show", id: documentResourceInstance.id)
    }

    def show(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "list")
            return
        }

        [documentResourceInstance: documentResourceInstance]
    }

    def edit(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "list")
            return
        }

        [documentResourceInstance: documentResourceInstance]
    }

    def update(Long id, Long version) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (documentResourceInstance.version > version) {
                documentResourceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'documentResource.label', default: 'DocumentResource')] as Object[],
                        "Another user has updated this DocumentResource while you were editing")
                render(view: "edit", model: [documentResourceInstance: documentResourceInstance])
                return
            }
        }

        documentResourceInstance.properties = params

        if (!documentResourceInstance.save(flush: true)) {
            render(view: "edit", model: [documentResourceInstance: documentResourceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), documentResourceInstance.id])
        redirect(action: "show", id: documentResourceInstance.id)
    }

    def delete(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "list")
            return
        }

        try {
            documentResourceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'documentResource.label', default: 'DocumentResource'), id])
            redirect(action: "show", id: id)
        }
    }

    //todo
    def saveDocument(DocumentResourceAdderCO documentResourceAdderCO) {

        def file = documentResourceAdderCO.myFile
        def typeOfFile = file.contentType
        if (!(typeOfFile == 'application/pdf')) {
            flash.message = "Only pdf File Format Supported"
            redirect(controller: 'documentResource', action: 'list')
            return false
        }
        def path = grailsApplication.config.uploadPath
        Long newId = documentResourceService.commandObjectBinding(documentResourceAdderCO, path)
        redirect(controller: 'topic', action: 'show', params: ['id': newId])
    }

    def download(Long id) {
        def wantedFile = DocumentResource.get(id)
        byte[] sourcePdf = new File("${grailsApplication.config.uploadPath}/${id}").bytes
        response.setContentType("application/pdf")
        response.setHeader("Content-disposition", "attachment; filename=" + wantedFile.fileName)
        response.contentLength = sourcePdf.length
        response.outputStream << sourcePdf
    }
}
