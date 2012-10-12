package com.intelligrape.learngrails

class QuestionTagController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [questionTagInstanceList: QuestionTag.list(params), questionTagInstanceTotal: QuestionTag.count()]
    }

    def create = {
        def questionTagInstance = new QuestionTag()
        questionTagInstance.properties = params
        return [questionTagInstance: questionTagInstance]
    }

    def save = {
        def questionTagInstance = new QuestionTag(params)
        if (questionTagInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), questionTagInstance])}"
            redirect(action: "show", id: questionTagInstance.id)
        }
        else {
            render(view: "create", model: [questionTagInstance: questionTagInstance])
        }
    }

    def show = {
        def questionTagInstance = QuestionTag.get(params.id)
        if (!questionTagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
            redirect(action: "list")
        }
        else {
            [questionTagInstance: questionTagInstance]
        }
    }

    def edit = {
        def questionTagInstance = QuestionTag.get(params.id)
        if (!questionTagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [questionTagInstance: questionTagInstance]
        }
    }

    def update = {
        def questionTagInstance = QuestionTag.get(params.id)
        if (questionTagInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (questionTagInstance.version > version) {

                    questionTagInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'questionTag.label', default: 'QuestionTag')] as Object[], "Another user has updated this QuestionTag while you were editing")
                    render(view: "edit", model: [questionTagInstance: questionTagInstance])
                    return
                }
            }
            questionTagInstance.properties = params
            if (!questionTagInstance.hasErrors() && questionTagInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), questionTagInstance])}"
                redirect(action: "show", id: questionTagInstance.id)
            }
            else {
                render(view: "edit", model: [questionTagInstance: questionTagInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def questionTagInstance = QuestionTag.get(params.id)
        if (questionTagInstance) {
            try {
                questionTagInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionTag.label', default: 'QuestionTag'), params.id])}"
            redirect(action: "list")
        }
    }
}
