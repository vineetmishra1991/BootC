package com.ig.bc

class MyTagTagLib {

    static namespace = "myTag"
    def test = {attrs->
        String message = attrs.message
        Integer number = attrs.number
        Integer number2 = attrs.number2


        out << "Action:   ${actionName}, Controller:  ${controllerName} <br/> <li>message:${message}</li>  ,<strong>Number: ${number}</strong> ,Number2: ${number2}"
    }

}
