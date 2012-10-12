package com.intelligrape.learngrails

import grails.plugins.springsecurity.Secured
import grails.gorm.DetachedCriteria

class QuestionController {

    def scaffold = true
    def answerService
    def springSecurityService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def create(Long id) {
        def questionOptionInstance = id ? QuestionOption.get(id) : new QuestionOption(params)
        if (!questionOptionInstance) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'questionOption.label', default: 'QuestionOption'), id])
            redirect(action: "list")
        } else {

            [questionOptionInstance: questionOptionInstance, userId: currentUser()?.id]
        }
    }

    def listTagQuestion = {

        Long tagId = params.long('id')
        User user = currentUser()
        if (tagId) {
            session.tagID = tagId
        }
        Tag tag = tagId ? Tag.get(tagId) : Tag.get(session.tagID)
        List<Question> questionsList = Question.getUnAttemptedQuestions(user, tag, 10, 0)
        [questionList: questionsList]
    }

    def showQuestionOption = {
        String error = "No"
        User user = currentUser()
        int offset = params.offset ? params.int('offset') + 1 : 0
        if (params.id) {
            Question question = Question.get(params.long('id'))
            List<QuestionOption> answerOptions = question.questionOptions as List<QuestionOption>
            [answerOptions: answerOptions, question: question, offset: 0, totalCount: 2]
        }
        else {
            Tag tag = Tag.get(session.tagID)
            List<Question> questionsList = Question.getUnAttemptedQuestions(user, tag, 1, offset)
            def count = questionsList.totalCount
            if (questionsList) {
                [answerOptions: questionsList[0].questionOptions as List<QuestionOption>, question: questionsList[0], offset: offset, totalCount: count]
            }
            else {
                offset = 0
                List<Question> questionList = Question.getUnAttemptedQuestions(user, tag, 1, offset)
                def questionCount = questionList.totalCount
                if (questionList) {
                    [answerOptions: questionList[0].questionOptions as List<QuestionOption>, question: questionList[0], offset: offset, totalCount: questionCount]
                }
                else {
                    [error: error]
                }
            }
        }
    }

    def addRatingToQuestion() {
        User user = currentUser()
        def usefulness = params.usefulnessVal
        QuestionOption questionOption = QuestionOption.get(params.long('answerID'))
        Question question = Question.get(params.long('questionId'))
        def response = answerService.ratingToQuestion(user, questionOption, question, usefulness)
        if (response == "attempted") {
            render(template: '/answer/alreadyAttemptedMessage')
        }
        else if (response == "correct") {
            render(template: '/questionOption/correctAnswerMessage', model: [tagName: Tag.get(session.tagID)])
        }
        else if (response instanceof QuestionOption) {
            render(template: '/questionOption/incorrectAnswerMessage', model: [correctAnswer: response])

        }
    }

    private currentUser() {

        return User.get(springSecurityService.principal.id)
    }

    def save = {  QuestionCommand questionCommand ->

        Question question = new Question(title: questionCommand.title, description: questionCommand.description, user: currentUser())
        println "params are"
        questionCommand.questionOptions?.each {
            if (it) {
                println "--------------------" + it.isCorrect
                println "it.isCorrect?questionCommand.justification:\"\"" + it.isCorrect ? params.justification : ""
                QuestionOption questionOption = new QuestionOption(description: it.description, justification: it.isCorrect ? params.justification : "", isCorrect: it.isCorrect)
                question.addToQuestionOptions(questionOption).save()
            }
        }
        Tag getTag = Tag.findByName(questionCommand.tag)
        question.addToQuestionTags(new QuestionTag(tag: getTag)).save(flush: true)
        question.save(flush: true, failOnError: true)
        redirect(action: 'list')
    }

    def test2() {
        Tag tag = Tag.get(session.tagID)
        def userList = Answer.createCriteria().list()
                {
                    projections {
                        groupProperty('user')
                        rowCount()
//                        count('question', 'q')
                    }
                    'question' {
                        'questionTags' {
                            'eq'('tag', tag)
                        }
                    }
                    'eq'('usefulness', Usefulness.MOST_USEFUL)
//                    order('q', 'desc')
                    maxResults 3
                }
        println userList
    }
}