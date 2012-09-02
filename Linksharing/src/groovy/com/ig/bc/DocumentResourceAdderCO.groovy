package com.ig.bc
import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class DocumentResourceAdderCO {

    String fileName
    String contentType
    String title
    String summary
    Long id
    CommonsMultipartFile myFile
}
