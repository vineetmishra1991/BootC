package com.intelligrape.learngrails

import org.springframework.dao.DataIntegrityViolationException

class QuestionOptionController {

    static scaffold = true
    static allowedMethods = [save: "POST", delete: "POST"]

    def save = { QuestionOptionCommand questionOptionCommand ->
        QuestionOption questionOption = new QuestionOption()
        questionOption.properties = questionOptionCommand.properties
        println "JJJJJJJJJJJJJJJJJJJJ" + questionOption.properties
        questionOption.save()
        redirect(action: 'list')


    }

}