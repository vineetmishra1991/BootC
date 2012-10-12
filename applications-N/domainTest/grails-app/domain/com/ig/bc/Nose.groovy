package com.ig.bc

import domaintest.Auth_Nose

class Nose {
    String name
//    static belongsTo = [face: Face]
    static hasMany = [auth_nose:Auth_Nose]
    static constraints = {

//        face(nullable: true)

    }
}
