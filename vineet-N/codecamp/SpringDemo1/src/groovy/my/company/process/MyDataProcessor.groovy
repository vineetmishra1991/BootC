package my.company.process

//import src.*

import org.springframework.stereotype.Component
import org.springframework.context.annotation.Scope
import org.springframework.beans.factory.annotation.Autowired
import my.company.area.Shape
import org.springframework.beans.factory.annotation.Qualifier

@Component
@Scope("prototype") // return new object when requested
/***
 *     singleton – Return a single bean instance per Spring IoC container
 prototype – Return a new bean instance each time when requested
 request – Return a single bean instance per HTTP request. *
 session – Return a single bean instance per HTTP session. *
 globalSession – Return a single bean instance per global HTTP session. *
 */
class MyDataProcessor {

    @Autowired
    @Qualifier("triangle")
    private Shape shape

    String makeToUpperCase(String data) {
        return data.toUpperCase() + ":::::::::::::::"
    }

    String drawNew() {
        shape.draw()
    }
}
