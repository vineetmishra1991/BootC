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
        [documentresourceInstanceList: DocumentResource.list(params), documentresourceInstanceTotal: DocumentResource.count()]
    }

    def create() {
        [documentresourceInstance: new DocumentResource(params)]
    }

    def save(DocumentResourceAdderCO documentResourceAdderCO) {

        def file = documentResourceAdderCO.myFile
        def typeOfFile = file.contentType
        if (!(typeOfFile == 'application/pdf')) {
            flash.message = "Only pdf File Format Supported"
            redirect(controller: 'documentResource', action: 'list')
            return false
        }
        def path = grailsApplication.config.uploadPath
        documentResourceService.commandObjectBinding(documentResourceAdderCO, path)
    }

    def show(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        [documentresourceInstance: documentResourceInstance]
    }

    def edit(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        [documentresourceInstance: documentResourceInstance]
    }

    def update(Long id, Long version) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (documentResourceInstance.version > version) {
                documentResourceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'documentresource.label', default: 'Documentresource')] as Object[],
                        "Another user has updated this Documentresource while you were editing")
                render(view: "edit", model: [documentresourceInstance: documentResourceInstance])
                return
            }
        }

        documentResourceInstance.properties = params

        if (!documentResourceInstance.save(flush: true)) {
            render(view: "edit", model: [documentresourceInstance: documentResourceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), documentResourceInstance.id])
        redirect(action: "show", id: documentResourceInstance.id)
    }

    def delete(Long id) {
        def documentResourceInstance = DocumentResource.get(id)
        if (!documentResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        try {
            documentResourceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "show", id: id)
        }
    }
}