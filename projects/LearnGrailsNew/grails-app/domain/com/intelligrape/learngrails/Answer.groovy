package com.intelligrape.learngrails

class Answer {

    Usefulness usefulness
    QuestionOption questionOption
    static belongsTo = [question: Question, user: User]
    static constraints = {
        question(unique: 'user')
    }

    static Boolean isAttempted(User user, Question question) {

        if (Answer.countByQuestionAndUser(question, user)) {
            return true
        }
    }
}
