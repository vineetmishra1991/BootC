package com.ig.bc

class DocumentResource extends Resource {

    String fileName
    String contentType

    static constraints = {

        fileName(blank: true, nullable: true)
        contentType(blank: true, nullable: true)
    }
}
