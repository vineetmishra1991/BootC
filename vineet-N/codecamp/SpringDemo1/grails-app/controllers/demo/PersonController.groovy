package demo

import grails.converters.JSON
import grails.converters.XML
import my.company.area.Shape
import my.company.process.MyDataProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

class PersonController {
    //def utility

    @Autowired
//    @Qualifier("triangle")
    private MyDataProcessor myProcessor;

//    @Autowired
//    @Qualifier("triangle")
//    private Shape shape;

    static allowedMethods = [save: "POST", update: ["POST", "PUT"], delete: ["POST", "DELETE"]]

    def index() {
        String data = params.data as String
        data = data ?: "hello"
        render("Data:::" + myProcessor.makeToUpperCase(data) + ":::::Hashcode:::::${myProcessor.hashCode()}:::" + myProcessor.drawNew())
//        render(":::::::::::" + shape.draw())
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        withFormat {
            html { [personInstanceList: Person.list(params), personInstanceTotal: Person.count()] }
            xml { render Person.list(params) as XML }
            json { render Person.list(params) as JSON }
            js { render Person.list(params) as JSON }
        }

    }

    def create() {
        [personInstance: new Person(params)]
    }

    def save() {
        def personInstance = new Person(request.format == 'xml' ? params.person : params)
        if (personInstance.save(flush: true)) {
            withFormat {
                form {
                    flash.message = "${message(code: 'default.created.message', args: [message(code: 'person.label', default: 'person'), personInstance.id])}"
                    redirect(action: "show", id: personInstance.id)
                }
                xml {
                    response.status = 200 // OK
                    render personInstance as XML
                }
                json {
                    response.status = 200 // OK
                    render personInstance as JSON
                }
            }
        }
        else {
            withFormat {
                form {
                    render(view: "create", model: [personInstance: personInstance])
                }
                xml {
                    response.status = 400 // Bad Request
                    render personInstance.errors as XML
                }
                json {
                    response.status = 400 // Bad Request
                    render personInstance.errors as JSON
                }
            }
        }
    }


    def show() {
        def personInstance = Person.get(params.id)

        if (!personInstance) {
            withFormat renderNotFound
        }
        else {
            withFormat {
                html { [personInstance: personInstance] }
                xml { render personInstance as XML }
                json { render personInstance as JSON }
            }
        }
    }


    def renderNotFound = {
        html {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
            return
        }
        xml {
            response.status = 404
            Map person = ['status': 'person not found.']
            render person as XML
        }
        json {
            response.status = 404
            Map person = ['status': 'person not found.']
            render person as JSON
        }
    }

    def edit() {
        def personInstance = Person.get(params.id)
        if (!personInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
            redirect(action: "list")
            return
        }

        [personInstance: personInstance]
    }

    def update() {

        def p = (request.format == 'xml' ? params.person : params)
        def personInstance = Person.get(params.id)
        if (personInstance) {
            if (p.version) {
                def version = p.version.toLong()
                if (personInstance.version > version) {
                    personInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'person.label', default: 'person')] as Object[], "Another user has updated this person while you were editing")
                    withFormat render409orEdit.curry(personInstance)
                    return
                }
            }
            personInstance.properties = p
            if (!personInstance.hasErrors() && personInstance.save(flush: true)) {
                withFormat {
                    form {
                        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'person'), personInstance.id])}"
                        redirect(action: "show", id: personInstance.id)
                    }
                    xml {
                        response.status = 200 // OK
                        render personInstance as XML
                    }
                    json {
                        response.status = 200 // OK
                        render personInstance as JSON
                    }
                }
            }
            else {
                withFormat render409orEdit.curry(personInstance)
            }
        }
        else {
            withFormat renderNotFound
        }
    }



    def render409orEdit = { personInstance ->
        form {
            render(view: "edit", model: [personInstance: personInstance])
        }
        xml {
            response.status = 409 // Conflict
            render personInstance.errors.allErrors as XML
        }
        json {
            response.status = 409 // Conflict
            render personInstance.errors.allErrors as JSON
        }
    }

    def delete() {
        def personInstance = Person.get(params.id)
        try {
            personInstance.delete(flush: true)
            withFormat {
                form {
                    flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])}"
                    redirect(action: "list")
                }
                xml {
                    response.status = 200 // OK
                    String message = g.message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])
                    Map person = ['status': message]
                    render person as XML
                }
                json {
                    response.status = 200 // OK
                    String message = g.message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])
                    Map person = ['status': message]
                    render person as JSON
                }
            }
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            withFormat {
                form {
                    flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])}"
                    redirect(action: "show", id: params.id)
                }
                xml {
                    response.status = 409 // Conflict
                    String message = g.message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])
                    Map person = ['status': message]
                    render person as XML
                }
                json {
                    response.status = 409 // Conflict
                    String message = g.message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'person'), params.id])
                    Map person = ['status': message]
                    render person as JSON
                }
            }
        }
    }


}