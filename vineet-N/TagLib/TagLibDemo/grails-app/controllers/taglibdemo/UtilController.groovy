package taglibdemo

class UtilController {

    def index() { }

    def demoPage2() {
        println "demo page"
        String message = myTag.test(number: 1, number2: 2, message: "something")
        println "message:${message}"
        render message
    }
}
