package com.ig.bc

import org.springframework.web.multipart.commons.CommonsMultipartFile

/**
 * Created with IntelliJ IDEA.
 * User: intelligrape
 * Date: 25/8/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
class DocumentResourceAdderCO {

    String fileName
    String contentType
    String title
    String summary
    Long id
    CommonsMultipartFile myFile
}
