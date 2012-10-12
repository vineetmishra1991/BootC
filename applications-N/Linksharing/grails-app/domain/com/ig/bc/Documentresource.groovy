package com.ig.bc

class Documentresource extends Resource {

    String filename
    String contenttype

    static constraints = {

        filename(blank: true, nullable: true)
        contenttype(blank: true, nullable: true)
    }
}
