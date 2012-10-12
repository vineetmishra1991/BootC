package com.ig.bc

class Tag {

    String name
    static hasMany = [questions: Question]
    static constraints = {
    }
}
