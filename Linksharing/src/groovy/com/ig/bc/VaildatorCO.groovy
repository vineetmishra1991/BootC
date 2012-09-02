package com.ig.bc

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class VaildatorCO {

    String email1
    String email2
    String email3

    static constraints = {
        email1(nullable: false, email: true)
        email2(nullable: false, email: true)
        email3(nullable: true, url: true)
    }

}


