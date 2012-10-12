package apackage;

import demo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonRest {

    @RequestMapping(value = "/person", method = RequestMethod.POST)

    public @ResponseBody Person getPersonData(@RequestBody Person person1) {
        System.out.println("hellloooooo:person1:::::::::"+person1);
        //Person person = (Person)Person.get(1);
        //System.out.println("person===" + person);
        return null;
    }
}
