package com.ig.bc

import domaintest.Auth_Nose

class Author {
    String name
    static hasMany = [auth_nose: Auth_Nose]

    static constraints = {
    }
}
