package apackage

import org.springframework.stereotype.Service
import demo.Person
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 9/22/12
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
class CheckServiceAnn {

    @Transactional
    boolean  saveData(){
        Person person = new Person(firstName: "firtname0000000",lastName: "last name",email: "aaaa@aaaaaa.com",address: "addd",age: 10)
        person.save(flush: true,failOnError: true)

        Person person1 = new Person(firstName: "firtname",lastName: "last111 name",email: "bbbbbb@aaaa.com",address: "addd",age: 10)
        person1.save(flush: true,failOnError: true)
    }
}
