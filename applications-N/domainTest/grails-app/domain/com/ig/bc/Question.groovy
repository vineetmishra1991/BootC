package com.ig.bc

class Question {
    String name
    static hasMany = [tags: Tag]
    static belongsTo = Tag
    static constraints = {
    }
}
