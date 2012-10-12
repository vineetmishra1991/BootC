package com.ig.bc

class FaceController {
//    def scaffold = true
    def test() {
        Nose nose1 = new Nose(name: 'nose1').save(flush: true)

        Face face1 = new Face(nose: nose1).save(flush: true, failOnError: true)
//        Face face2 = new Face(nose: nose1).save(flush: true, failOnError: true)
//        Face face3 = new Face(nose: nose1).save(flush: true, failOnError: true)

    }

}
