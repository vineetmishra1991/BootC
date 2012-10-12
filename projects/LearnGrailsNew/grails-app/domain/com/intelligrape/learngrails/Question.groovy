package com.intelligrape.learngrails

import grails.gorm.DetachedCriteria

class Question {

    String title
    String description
    List questionOptions
    static hasMany = [answers: Answer, questionTags: QuestionTag, questionOptions: QuestionOption]
    static belongsTo = [user: User]
    static constraints = {
    }

    int hashCode() {
        this.id.hashCode()
    }

    boolean equals(Object other) {
        if (other instanceof Question) {
            this.id == other.id
        }
        else return false
    }

    static List<Question> getUnAttemptedQuestions(User user, Tag tag, int max, int offset) {

        int answersAttempted = Answer.countByUser(user)
        List<Question> questions = Question.createCriteria().list(max: max, offset: offset) {
            questionTags {
                eq('tag', tag)
            }
            if (answersAttempted) {
                not {
                    'in'('id', new DetachedCriteria(Answer).build {
                        projections {
                            property('question.id')
                        }
                        eq('user', user)
                    }.list())
                }
            }
        }
        return questions
    }
}
