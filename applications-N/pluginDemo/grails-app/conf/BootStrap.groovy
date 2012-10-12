import plugindemo.Person

class BootStrap {

    def init = { servletContext ->

        (0..10).each {Integer index ->
            Person person = new Person()
            person.name = "Vishal-${index}"
            person.email = "vishal+${index}@intelligrape.com"
            person.designation = "Sr Software Engineer ${index}"
            person.save(flush: true)
        }

    }
    def destroy = {
    }
}
