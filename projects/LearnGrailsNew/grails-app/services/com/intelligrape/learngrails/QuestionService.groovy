package com.intelligrape.learngrails

class QuestionService {
    def bootStrapService

    def createMultipleChoiceQuestion(String questionText,
                                     List questionOptions)

    {
        Question newQuestion = new Question(description: questionText)
        questionOptions.each {
            QuestionOption result = bootStrapService.questionOptionInit(newQuestion, it.correct.equals("on") ? true : false, it.description, it.correct.equals("on") ? it.justification : "")
            newQuestion.addToQuestionOptions(result)
        }
        return newQuestion
    }


}
