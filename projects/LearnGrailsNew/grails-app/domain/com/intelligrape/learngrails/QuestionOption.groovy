package com.intelligrape.learngrails

class QuestionOption {

    boolean isCorrect
    String justification
    String description

    static belongsTo = [question: Question]

    static mapping = {
        justification type: 'text'

    }
    static constraints = {
        justification(nullable: true)
        description(nullable: true)
    }

    static QuestionOption correctAnswer(Question question) {

        return QuestionOption.findByQuestionAndIsCorrect(question, true)

    }
}
