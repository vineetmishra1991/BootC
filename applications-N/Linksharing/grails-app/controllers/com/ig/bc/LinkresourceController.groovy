package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class LinkresourceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [linkresourceInstanceList: Linkresource.list(params), linkresourceInstanceTotal: Linkresource.count()]
    }

    def create() {
        [linkresourceInstance: new Linkresource(params)]
    }

    def save() {
        def linkresourceInstance = new Linkresource(params)
        if (!linkresourceInstance.save(flush: true)) {
            render(view: "create", model: [linkresourceInstance: linkresourceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), linkresourceInstance.id])
        redirect(action: "show", id: linkresourceInstance.id)
    }

    def show(Long id) {
        def linkresourceInstance = Linkresource.get(id)
        if (!linkresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        [linkresourceInstance: linkresourceInstance]
    }

    def edit(Long id) {
        def linkresourceInstance = Linkresource.get(id)
        if (!linkresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        [linkresourceInstance: linkresourceInstance]
    }

    def update(Long id, Long version) {
        def linkresourceInstance = Linkresource.get(id)
        if (!linkresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (linkresourceInstance.version > version) {
                linkresourceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'linkresource.label', default: 'Linkresource')] as Object[],
                        "Another user has updated this Linkresource while you were editing")
                render(view: "edit", model: [linkresourceInstance: linkresourceInstance])
                return
            }
        }

        linkresourceInstance.properties = params

        if (!linkresourceInstance.save(flush: true)) {
            render(view: "edit", model: [linkresourceInstance: linkresourceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), linkresourceInstance.id])
        redirect(action: "show", id: linkresourceInstance.id)
    }

    def delete(Long id) {
        def linkresourceInstance = Linkresource.get(id)
        if (!linkresourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        try {
            linkresourceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "show", id: id)
        }
    }
}
