package my.company.area

import org.springframework.stereotype.Component


@Component
class Triangle implements Shape {
    public String draw(){
        return "Triangle Drawn"
    }
}
