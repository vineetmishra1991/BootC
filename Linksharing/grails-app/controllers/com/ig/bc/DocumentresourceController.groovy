package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class DocumentresourceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [documentresourceInstanceList: Documentresource.list(params), documentresourceInstanceTotal: Documentresource.count()]
    }

    def create() {
        [documentresourceInstance: new Documentresource(params)]
    }

    def save() {
        def documentresourceInstance = new Documentresource(params)
        if (!documentresourceInstance.save(flush: true)) {
            render(view: "create", model: [documentresourceInstance: documentresourceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), documentresourceInstance.id])
        redirect(action: "show", id: documentresourceInstance.id)
    }

    def show(Long id) {
        def documentresourceInstance = Documentresource.get(id)
        if (!documentresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        [documentresourceInstance: documentresourceInstance]
    }

    def edit(Long id) {
        def documentresourceInstance = Documentresource.get(id)
        if (!documentresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        [documentresourceInstance: documentresourceInstance]
    }

    def update(Long id, Long version) {
        def documentresourceInstance = Documentresource.get(id)
        if (!documentresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (documentresourceInstance.version > version) {
                documentresourceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'documentresource.label', default: 'Documentresource')] as Object[],
                          "Another user has updated this Documentresource while you were editing")
                render(view: "edit", model: [documentresourceInstance: documentresourceInstance])
                return
            }
        }

        documentresourceInstance.properties = params

        if (!documentresourceInstance.save(flush: true)) {
            render(view: "edit", model: [documentresourceInstance: documentresourceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), documentresourceInstance.id])
        redirect(action: "show", id: documentresourceInstance.id)
    }

    def delete(Long id) {
        def documentresourceInstance = Documentresource.get(id)
        if (!documentresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
            return
        }

        try {
            documentresourceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'documentresource.label', default: 'Documentresource'), id])
            redirect(action: "show", id: id)
        }
    }
}
