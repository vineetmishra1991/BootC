package com.intelligrape.learngrails

class Tag {
    String name

    static hasMany = [questionTags: QuestionTag]

    String toString() {
        return name
    }

    static constraints = {
    }


}
