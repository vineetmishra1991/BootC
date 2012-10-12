package com.intelligrape.learngrails

class User {

    transient springSecurityService

    String username
    String password
    String address
    String email
    Date dateOfBirth
    Date dateCreated
    Date lastUpdated
    Gender gender
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [questions: Question, answers: Answer]

    static constraints = {
        username blank: false, unique: true
        password blank: false
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        email(email: true, unique: true)
    }

    static mapping = {
        password column: '`password`'
        tablePerHierarchy false
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }

    String toString() {
        return username
    }
}
