package com.ig.bc

class Documentresource extends Resource {

    String filename
    String contenttype

    static constraints = {

        filename(blank: false,nullable: false)
        contenttype(blank: false,nullable: false)
    }
}
