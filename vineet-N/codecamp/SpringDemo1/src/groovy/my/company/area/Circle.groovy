package my.company.area

import org.springframework.stereotype.Component

@Component
class Circle implements Shape {
    public String draw(){
        return "Circle Drawn"
    }
}
