package com.ig.bc

class AuthorController {

    def beforeInterceptor = [action: this.&myAction, except: 'index']

    def myAction() {
        println "Hello"
    }

    def index() {
        println controllerName + "\n" + actionName + "\n" + actionUri + "\n" + controllerUri + "\n" + response
    }

    def test() {
//        render(view: "/index", model: ['name': 'Vineet', 'age': '17'])
        println "After before interceptor"
    }

    def intercept(model, modelAndView) {
        println model
        println modelAndView.viewName + "++"
        println "Tracing action ${actionUri}"
    }

//    def afterInterceptor = [action: this.&intercept]
    def afterInterceptor = { model, modelAndView ->
        println "Current view is ${modelAndView.viewName}"
//        if (model.name)
        modelAndView.viewName = "/author/intercept"
        println "View is now ${modelAndView.viewName}"
    }

}
