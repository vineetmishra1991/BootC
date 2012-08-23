package com.ig.bc

import org.codehaus.groovy.grails.validation.Validateable

/**
 * Created with IntelliJ IDEA.
 * User: intelligrape
 * Date: 23/8/12
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
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


