package com.intelligrape.learngrails

class QuestionTag {

    static belongsTo = [question:Question,tag:Tag]
    static constraints = {
    }
}
