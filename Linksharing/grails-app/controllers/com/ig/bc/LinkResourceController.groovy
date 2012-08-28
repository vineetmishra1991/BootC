package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class LinkResourceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [linkresourceInstanceList: LinkResource.list(params), linkresourceInstanceTotal: LinkResource.count()]
    }

    def create() {
        [linkresourceInstance: new LinkResource(params)]
    }

    def save() {
        def linkResourceInstance = new LinkResource(params)
        if (!linkResourceInstance.save(flush: true)) {
            render(view: "create", model: [linkresourceInstance: linkResourceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), linkResourceInstance.id])
        redirect(action: "show", id: linkResourceInstance.id)
    }

    def show(Long id) {
        def linkResourceInstance = LinkResource.get(id)
        if (!linkResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        [linkresourceInstance: linkResourceInstance]
    }

    def edit(Long id) {
        def linkResourceInstance = LinkResource.get(id)
        if (!linkResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        [linkresourceInstance: linkResourceInstance]
    }

    def update(Long id, Long version) {
        def linkResourceInstance = LinkResource.get(id)
        if (!linkResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (linkResourceInstance.version > version) {
                linkResourceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'linkresource.label', default: 'Linkresource')] as Object[],
                        "Another user has updated this Linkresource while you were editing")
                render(view: "edit", model: [linkresourceInstance: linkResourceInstance])
                return
            }
        }

        linkResourceInstance.properties = params

        if (!linkResourceInstance.save(flush: true)) {
            render(view: "edit", model: [linkresourceInstance: linkResourceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), linkResourceInstance.id])
        redirect(action: "show", id: linkResourceInstance.id)
    }

    def delete(Long id) {
        def linkResourceInstance = LinkResource.get(id)
        if (!linkResourceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
            return
        }

        try {
            linkResourceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'linkresource.label', default: 'Linkresource'), id])
            redirect(action: "show", id: id)
        }
    }
}
