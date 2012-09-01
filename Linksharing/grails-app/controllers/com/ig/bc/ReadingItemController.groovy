package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class ReadingItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [readingItemInstanceList: ReadingItem.list(params), readingItemInstanceTotal: ReadingItem.count()]
    }

    def create() {
        [readingItemInstance: new ReadingItem(params)]
    }

    def save() {
        def readingItemInstance = new ReadingItem(params)
        if (!readingItemInstance.save(flush: true)) {
            render(view: "create", model: [readingItemInstance: readingItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), readingItemInstance.id])
        redirect(action: "show", id: readingItemInstance.id)
    }

    def show(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "list")
            return
        }

        [readingItemInstance: readingItemInstance]
    }

    def edit(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "list")
            return
        }

        [readingItemInstance: readingItemInstance]
    }

    def update(Long id, Long version) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (readingItemInstance.version > version) {
                readingItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'readingItem.label', default: 'ReadingItem')] as Object[],
                        "Another user has updated this ReadingItem while you were editing")
                render(view: "edit", model: [readingItemInstance: readingItemInstance])
                return
            }
        }

        readingItemInstance.properties = params

        if (!readingItemInstance.save(flush: true)) {
            render(view: "edit", model: [readingItemInstance: readingItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), readingItemInstance.id])
        redirect(action: "show", id: readingItemInstance.id)
    }

    def delete(Long id) {
        def readingItemInstance = ReadingItem.get(id)
        if (!readingItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "list")
            return
        }

        try {
            readingItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'readingItem.label', default: 'ReadingItem'), id])
            redirect(action: "show", id: id)
        }
    }

    def markRead() {
        def id = params.item
        ReadingItem item = ReadingItem.get(id)
        item.isRead = true
        render true
    }
}
