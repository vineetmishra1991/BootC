package apackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 9/11/12
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
class CheckForCompnent {

    @Autowired
    private LoggerData loggerData;



    void fetchData() {
        System.out.println(loggerData.getData("hello"));
    }

}
