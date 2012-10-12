package apackage

import org.aspectj.lang.ProceedingJoinPoint
import org.springframework.util.StopWatch

import org.springframework.stereotype.Component
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Around

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 9/14/12
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */

class SimpleProfiler {



    public Object profile(ProceedingJoinPoint call, String name, int age) throws Throwable {
        StopWatch clock = new StopWatch(
                "Profiling for '" + name + "' and '" + age + "'");
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
