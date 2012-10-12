package com.intelligrape.learngrails

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", delete: "POST"]

    def beforeInterceptor = [action: this.&checkPassword, only: 'save']

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create(Long id) {
        def userInstance = id ? User.get(id) : new User(params)
        if (!userInstance) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        } else {
            [userInstance: userInstance]
        }
    }

    def checkPassword() {
        if (params.confirmPassword == params.password) {
            return true
        }
        else {
            def userInstance = new User(params)
            flash.message = "Confirm Password and Password don't match"
            redirect(action: "create", params: params)
            return false
        }
    }

    def save(Long id, Long version) {

        def userInstance = id ? User.get(id) : new User(params)
        if (!userInstance) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'user.label', default: 'User')] as Object[],
                        "Another user has updated this User while you were editing")
                render(view: "create", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        if (id) {
            flash.success = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        } else {
            flash.success = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        }
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.success = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.error = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }

    def home() {

    }
}
