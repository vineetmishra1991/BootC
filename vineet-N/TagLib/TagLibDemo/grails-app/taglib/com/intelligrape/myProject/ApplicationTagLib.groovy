package com.intelligrape.myProject

class ApplicationTagLib {
//    static namespace = "ig"

    def firstTag = {attrs ->
        out << "Newly created tag"
    }

    def secondTag = {attrs ->

        out << "Newly created tag having ${attrs.value}"
    }


    def iterateOnNumber = {attrs ->
        String outputString = "<ul>"
        List numberList = [1, 2, 3]
        numberList.each {number ->
            outputString += "<li>User:${number}</li>"
            outputString += "<li>Salary : ${number * 0.10}</li>"
        }
        outputString += "</ul>"
        out << outputString

    }


    def testingOtherAttributes = {attrs ->

        out << "Controller name: ${controllerName} <br/>"
        out << "Action name: ${actionName} <br/>"
        out << "Grails application bean: ${grailsApplication.config.testPageMessage}<br/>"
    }


    def readingAttribute = {attrs ->
        String message = attrs.message
        Integer number = attrs.int('number')
        Long number2 = attrs.long('number2')
        Date date = attrs.date
        String m = "test"
        out << """Message: ${message}, Number: ${number}, Number2: ${number2},
 Date: ${date.format("MM dd yyyy")}"""
    }


    def boldItalic = {attrs, body ->

        out << "<strong><em>" << body() << "</strong></em>"
//        out << "<strong><em>" << body(number: 10) << "</strong></em>"
    }


    def test2 = {
        User user = User.list().first()
        out << render(template: '/util/mailMessage', model: [user: user])
    }

    def sortUserList = {attrs ->

        Integer max = attrs.int('max') ?: 10
        String sort = attrs.sort ?: 'id'
        List<User> userList = User.list(sort: sort, max: max)
        userList.each {
            out << "${it} <br/>"
        }
    }

}
