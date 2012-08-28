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
        def readingitemInstance = new ReadingItem(params)
        if (!readingitemInstance.save(flush: true)) {
            render(view: "create", model: [readingitemInstance: readingitemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), readingitemInstance.id])
        redirect(action: "show", id: readingitemInstance.id)
    }

    def show(Long id) {
        def readingitemInstance = ReadingItem.get(id)
        if (!readingitemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        [readingitemInstance: readingitemInstance]
    }

    def edit(Long id) {
        def readingitemInstance = ReadingItem.get(id)
        if (!readingitemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        [readingitemInstance: readingitemInstance]
    }

    def update(Long id, Long version) {
        def readingitemInstance = ReadingItem.get(id)
        if (!readingitemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (readingitemInstance.version > version) {
                readingitemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'readingitem.label', default: 'Readingitem')] as Object[],
                        "Another user has updated this Readingitem while you were editing")
                render(view: "edit", model: [readingitemInstance: readingitemInstance])
                return
            }
        }

        readingitemInstance.properties = params

        if (!readingitemInstance.save(flush: true)) {
            render(view: "edit", model: [readingitemInstance: readingitemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), readingitemInstance.id])
        redirect(action: "show", id: readingitemInstance.id)
    }

    def delete(Long id) {
        def readingitemInstance = ReadingItem.get(id)
        if (!readingitemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'readingitem.label', default: 'Readingitem'), id])
            redirect(action: "list")
            return
        }

        try {
            readingitemInstance.delete(flush: true)
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
