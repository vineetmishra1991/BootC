package com.ig.bc

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create() {
        [userInstance: new User(params)]
    }

    def save() {
        def userInstance = new User(params)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def show(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def edit(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'user.label', default: 'User')] as Object[],
                        "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params

        if (!userInstance.save(flush: true)) {
            render(view: "edit", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(action: "show", id: userInstance.id)
    }

    def delete(Long id) {
        def userInstance = User.get(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
            return
        }

        try {
            userInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(action: "show", id: id)
        }
    }

    def test1() {
        flash.message = "(.)(.)This is flash message"
        println "Flash message in test 1--- > " + flash.message
        render view: "test"
    }

    def test2() {
        println "Flash message in test 2--- > " + flash.message
        render view: "test1"
    }

    def test3() {
        flash.message = "This is flash message B=>"
        println "Flash message in test 3--- > " + flash.message
        render view: "test"
    }

    def test4() {
        println params.password
        println "Flash message in test 4--- > " + flash.message
        render view: "test1"
    }

    def test5() {
        flash.message = "house"
        forward(action: 'test6')
    }

    def test6() {
        println "In your ${flash.message}" + actionName
        forward action: 'test7'
    }

    def test7() {
        println "In your ${flash.message}" + actionName
        forward action: 'test8'
    }

    def test8() {
        println "In your ${flash.message}" + actionName
        render view: 'test1'
    }

    def test9() {
        println " your ${flash.message}" + actionName
        render view: 'test1'
    }

    def init() {

        User user1 = new User(name: 'vineet', age: 21, num: 1000).save(flush: true)
        User user2 = new User(name: 'ashish', age: 19, num: 2000).save(flush: true)
        User user3 = new User(name: 'Ron', age: 19, num: 2000).save(flush: true)
        User user4 = new User(name: 'Harry', age: 20, num: 4000).save(flush: true)
    }

    def init2() {

        List<User> usersList = User.list()
        println "----->" + usersList
        List<User> users = User.list(max: 2, offset: 0)
        println "++++++>" + users
        println usersList[0]
    }
}
