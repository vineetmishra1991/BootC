package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class ReadingItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [readingitemInstanceList: ReadingItem.list(params), readingitemInstanceTotal: ReadingItem.count()]
    }

    def create() {
        [readingitemInstance: new ReadingItem(params)]
    }

    def save() {
        def readingItemInstance = new ReadingItem(params)
        if (!readingItemInstance.save(flush: true)) {
            render(view: "create", model: [readingitemInstance: readingItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), readingItemInstance.id])
        redirect(action: "show", id: readingItemInstance.id)
    }

    def show(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        [readingitemInstance: readingItemInstance]
    }

    def edit(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        [readingitemInstance: readingItemInstance]
    }

    def update(Long id, Long version) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (readingItemInstance.version > version) {
                readingItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'readingitem.label', default: 'Readingitem')] as Object[],
                        "Another user has updated this Readingitem while you were editing")
                render(view: "edit", model: [readingitemInstance: readingItemInstance])
                return
            }
        }

        readingItemInstance.properties = params

        if (!readingItemInstance.save(flush: true)) {
            render(view: "edit", model: [readingitemInstance: readingItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), readingItemInstance.id])
        redirect(action: "show", id: readingItemInstance.id)
    }

    def delete(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        try {
            readingItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "show", id: id)
        }
    }

    def markRead(Long id) {

        ReadingItem item = ReadingItem.get(id)
        item.isRead = true
        redirect(controller: 'user', action: 'dashboard')
    }
}
