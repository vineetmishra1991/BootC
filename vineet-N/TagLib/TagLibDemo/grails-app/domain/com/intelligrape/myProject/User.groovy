package com.intelligrape.myProject

class User {
    String email
    String userName
    static constraints = {
    }

    String toString() {
        return "Email: ${email}, User name: ${userName}"
    }
}
