package com.ig.bc

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

    def delete() {

        render "User Cannot Be Deleted !!"
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

    def dashboard() {
        User user = User.findByEmail(session.userEmail)
        def name = user.firstname
        render(view: 'dashboard', model: ['nameUser': name])
    }


    def register() {
        render(view: "register")

    }

    def saveUser() {
        Date date = params.date("dateOfBirth", "MM/dd/yyyy")
        User user = new User()
        user.firstname = params.firstname
        user.lastname = params.lastname
        user.email = params.email
        user.dateOfBirth = date
        user.password = params.password
        user.male = params.male
        user.address = params.address
        user.confirmPassword = params.confirmPassword
        user.save(flush: true, failOnError: true)

        session.userEmail = user.email
        redirect(controller: 'login')
    }

    def checkEmailAvailability() {
        def email = params.email
        def user = User.countByEmail(email)
        if (!user) {
            render true
        }
        else {
            render false
        }
    }

    def findUnread() {

        User user = User.findByEmail(session.userEmail)
        List<Subscription> subscriptions = Subscription.findAllBySubscriberAndSeriousness(user, Seriousness.SERIOUS)

        List<Topic> topics = subscriptions*.topic

        def readingItems = topics ? ReadingItem.createCriteria().list {

            eq('user', user)
            'resourceItem' {

                inList('topic', topics)
                gt('dateCreated', new Date() - 2)

            }

            eq('isRead', false)
            // maxResults 10
        } : []

        def readingItemsList = readingItems.groupBy {it.resourceItem.topic.name}

        render readingItemsList

    }

    def test() {

        User user = User.findByEmail(session.userEmail)
        def readingItems = ReadingItem.createCriteria().list {

            projections {

                groupProperty('isRead')
                count('user')

            }
            eq('user', user)

        }
        render readingItems
    }

    def testNew() {

        if ("") {
            render "hello"
        }
        else {
            render "Unreachable"
        }

    }

    def testNew1() {

        List<User> users = User.list()
        def firstNameList = users*.firstname

        render firstNameList.min()

    }

    def voTest() {

        User user = User.findByEmail(session.userEmail)
        Topic topic = Topic.findByOwner(user)
        List<Subscription> subscriptions = Subscription.findAllByTopic(topic)
        List<User> users = subscriptions*.subscriber

//        println topics*.name
//
//        user.getTopics().each {
//            println it.name
//        }
//
//        println user.topics*.name
        UserVo userVo = new UserVo(topic: topic, owner: user, subscribers: users)

        println userVo
    }
}