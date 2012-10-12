package com.intelligrape.learngrails

class BootStrapService {
    def springSecurityService

    def initializeData() {
        userInit()
        tagInit()
    }

    def userInit() {
        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true, failOnError: true)
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)

        10.times {it ->

            User user = new User(username: "user${it}", address: 'pvihar', email: "user@gmail${it}.com",
                    dateOfBirth: new Date(), gender: Gender.MALE, enabled: true, password: "user").save(flush: true)

            UserRole.create user, userRole
        }
        questionInit()
        answerInit()
        attemptAndRateQuestion()

    }

    def questionInit() {
        List<User> userList = User.list()
        new Question(description: 'What are closures in groovy ?', user: userList[0], title: 'Closures').save()
        new Question(description: "How to map domain 'Person' to table 'people' in database ?", user: userList[1], title: 'Custom mapping of domain to database').save()
        new Question(description: 'How will you clear contents of staging area without affecting the working directory ?', user: userList[2],
                title: 'Staging area(index)').save()
        new Question(description: 'How will you generate your public key ?', user: userList[3], title: 'SSH').save()
        new Question(description: 'How will you rename a file or directory ?', user: userList[4], title: 'Rename file/directory').save()
        new Question(description: 'How will create symbolic links ?', user: userList[5], title: 'Symbolic links').save()
        new Question(description: 'How will you install a package from ubuntu repository ?', user: userList[6], title: 'Installing package').save()
        new Question(description: 'How can you get different tables for domain classes in inheritance ?', user: userList[7], title: 'Database mapping').save()
        new Question(description: 'The maximum variables a custom validator can take are :', user: userList[8], title: 'Custom validator').save()
        new Question(description: "In which one of these hibernate won't perform dirty checking ?", user: userList[9], title: 'GORM').save()
    }

    def attemptAndRateQuestion() {
        List<QuestionOption> questionOptions = QuestionOption.list()
        List<Question> questions = Question.list()
        List<User> userList = User.list()
        Answer answer1 = new Answer(user: userList[0], question: questions[0], usefulness: Usefulness.MOST_USEFUL, questionOption: questionOptions[0]).save(failOnError: true)
        Answer answer4 = new Answer(user: userList[1], question: questions[0], usefulness: Usefulness.VERY_USEFUL, questionOption: questionOptions[4]).save(failOnError: true)
    }


    def answerInit() {
        List<Question> questionList = Question.list()

        questionOptionInit(questionList[0], false, 'They are methods', null)
        questionOptionInit(questionList[0], true, 'They are block of code given a name', '''They are block of code given a name and functions can accept closures as
parameters''')

        questionOptionInit(questionList[1], false, "static mapping ={'people'}", null)
        questionOptionInit(questionList[1], true, "static mapping ={table 'people'}", " 'table' keyword is required")


        questionOptionInit(questionList[2], false, "By doing 'git checkout'", null)
        questionOptionInit(questionList[2], true, "By doing 'git reset'", "'git checkout' is used to clear contents of working directory not the staging area")

        questionOptionInit(questionList[3], false, "ssh -keygen -t", null)
        questionOptionInit(questionList[3], true, "ssh -keygen -t -rsa", "You need to define the algorithm for generating the public key (RSA) ")

        questionOptionInit(questionList[4], false, "rn", null)
        questionOptionInit(questionList[4], true, "mv", 'mv is used which essentially moves the old file content into the new file')

        questionOptionInit(questionList[5], false, "link", null)
        questionOptionInit(questionList[5], true, "ln -s", 'ln -s makes a soft link of the required file')

        questionOptionInit(questionList[6], false, "sudo apt get <packagename>", null)
        questionOptionInit(questionList[6], true, "sudo apt-get install<packagename>", 'keyword install needs to be given')

        questionOptionInit(questionList[7], false, "hierarchy false", null)
        questionOptionInit(questionList[7], true, "tablePerHierarchy false", '''tablePerHierarchy is given in static mapping to get different tables for domains in
inheritance''')

        questionOptionInit(questionList[8], false, "3", null)
        questionOptionInit(questionList[8], true, "2", '''2 variables are obj and val, where obj is the object whose validation is required to be done while val is the
value of the feild on basis ofwhich validation of the object will be done''')

        questionOptionInit(questionList[9], false, "Person.get(1)", null)
        questionOptionInit(questionList[9], true, "Person.read(1)", """Here hibernate won't perform dirty checking ie it won't check whether the object
loaded which is in read only state has been changed or not by the user while in get the object loaded will be dirty checked""")

    }

    void questionOptionInit(Question question, Boolean isCorrect, String description, String justification) {

        question.addToQuestionOptions(new QuestionOption(isCorrect: isCorrect, description: description, justification: justification))
        question.save(flush: true, failOnError: true)

//        new QuestionOption(question: question, isCorrect: isCorrect, description: description, justification: justification)
    }

    def tagInit() {

        Tag tag1 = new Tag(name: 'Groovy').save(failOnError: true)
        Tag tag2 = new Tag(name: 'Grails').save(failOnError: true)
        Tag tag3 = new Tag(name: 'Git').save(failOnError: true)
        Tag tag4 = new Tag(name: 'Linux').save(failOnError: true)

        List<Question> questionList = Question.list()


        addQuestionsToTag(questionList[0], tag1)
        addQuestionsToTag(questionList[0], tag2)
        addQuestionsToTag(questionList[0], tag3)

        addQuestionsToTag(questionList[1], tag2)
        addQuestionsToTag(questionList[1], tag1)
        addQuestionsToTag(questionList[1], tag3)

        addQuestionsToTag(questionList[2], tag3)
        addQuestionsToTag(questionList[2], tag4)
        addQuestionsToTag(questionList[2], tag2)

        addQuestionsToTag(questionList[3], tag4)
        addQuestionsToTag(questionList[3], tag3)
        addQuestionsToTag(questionList[3], tag2)

        addQuestionsToTag(questionList[4], tag4)
        addQuestionsToTag(questionList[4], tag1)
        addQuestionsToTag(questionList[4], tag2)

        addQuestionsToTag(questionList[5], tag4)
        addQuestionsToTag(questionList[5], tag3)
        addQuestionsToTag(questionList[5], tag1)

        addQuestionsToTag(questionList[6], tag1)
        addQuestionsToTag(questionList[6], tag2)
        addQuestionsToTag(questionList[6], tag4)

        addQuestionsToTag(questionList[7], tag2)
        addQuestionsToTag(questionList[7], tag3)
        addQuestionsToTag(questionList[7], tag4)

        addQuestionsToTag(questionList[8], tag1)
        addQuestionsToTag(questionList[8], tag2)
        addQuestionsToTag(questionList[8], tag3)

        addQuestionsToTag(questionList[9], tag1)
        addQuestionsToTag(questionList[9], tag3)
        addQuestionsToTag(questionList[9], tag4)
    }

    void addQuestionsToTag(Question question, Tag tag) {
        new QuestionTag(question: question, tag: tag).save(flush: true, failOnError: true)
    }
}
