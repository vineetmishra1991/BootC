import com.intelligrape.myProject.User

class BootStrap {

    def init = { servletContext ->
        println "Bootstraping data......."
        if (!User.count()) {
            println "Populating users........"
            (1..30).each {
                new User(email: "gautam+${it}@intelligrape.com", userName: "gautam-${it}").save(flush: true)
            }
        }
        println "Bootstrapped data......."

    }
    def destroy = {
    }
}
