package com.intelligrape.learngrails

class AnswerService {

    def ratingToQuestion(User user, QuestionOption questionOption, Question question, def usefulness) {

        if (Answer.isAttempted(user, question)) {
            return "attempted"
        }

        else {
            Answer questionRatings = new Answer(user: user, usefulness: usefulness, question: question, questionOption: questionOption).save(failOnError: true)
            QuestionOption answerOpt = questionOption
            if (answerOpt.isCorrect) {
                return "correct"
            }
            else {
                QuestionOption correctAnswer = QuestionOption.correctAnswer(question)
                return correctAnswer
            }
        }
    }
}
