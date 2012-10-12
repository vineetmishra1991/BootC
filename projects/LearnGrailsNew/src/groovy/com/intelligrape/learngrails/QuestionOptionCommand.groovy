package com.intelligrape.learngrails
import grails.validation.Validateable
@Validateable
class QuestionOptionCommand {
   //Long questionId
    boolean isCorrect
    String description
    Question question

    @Override
    public String toString() {
        return "QuestionOptionCommand{" +
                "isCorrect=" + isCorrect +
                ", justification='" + justification + '\'' +
                ", description='" + description + '\'' +
                ", question=" + question +
                '}';
    }
}
