package com.ig.bc

class QuestionController {

    def index() { }

    def test1() {

        Question question = new Question(name: 'Question1').save(flush: true, failOnError: true)
        Question question1 = new Question(name: 'Question2').save(flush: true, failOnError: true)
        Question question2 = new Question(name: 'Question3').save(flush: true, failOnError: true)
        Question question3 = new Question(name: 'Question4').save(flush: true, failOnError: true)

        Tag tag1 = new Tag(name: 'Groovy').save(flush: true, failOnError: true)
        Tag tag2 = new Tag(name: 'Grails').save(flush: true, failOnError: true)
        Tag tag3 = new Tag(name: 'Git').save(flush: true, failOnError: true)
        Tag tag4 = new Tag(name: 'Linux').save(flush: true, failOnError: true)

//        question.addToTags(new QuestionTag(tag: tag1)).save(flush: true, failOnError: true)
//        question.addToTags(new QuestionTag(tag: tag2)).save(flush: true, failOnError: true)
//        question.addToTags(new QuestionTag(tag: tag3)).save(flush: true, failOnError: true)
//        question.addToTags(new QuestionTag(tag: tag4)).save(flush: true, failOnError: true)

        question.addToTags(tag1).save(flush: true, failOnError: true)
        question.addToTags(tag2).save(flush: true, failOnError: true)
        question.addToTags(tag3).save(flush: true, failOnError: true)
        question.addToTags(tag4).save(flush: true, failOnError: true)

        tag1.addToQuestions(question).save(flush: true, failOnError: true)
        tag1.addToQuestions(question1).save(flush: true, failOnError: true)
        tag1.addToQuestions(question2).save(flush: true, failOnError: true)
        tag1.addToQuestions(question3).save(flush: true, failOnError: true)

        tag2.addToQuestions(question).save(flush: true, failOnError: true)
        tag2.addToQuestions(question1).save(flush: true, failOnError: true)
        tag2.addToQuestions(question2).save(flush: true, failOnError: true)
        tag2.addToQuestions(question3).save(flush: true, failOnError: true)

        tag1.delete(flush: true, failonError: true)

        def tags = Tag.list()
        println tags*.name

        def question8 = Question.list()
        println question8*.name
    }
}
