package apackage

import org.apache.commons.logging.LogFactory
import org.aspectj.lang.ProceedingJoinPoint

public class AnotherAspect {

    def log = LogFactory.getLog(AnotherAspect)

    def calls = 0

    public Object invoke(ProceedingJoinPoint method) throws Throwable
    {
        calls++

        println("AnotherAspect: Before Invoking Method====="+method);

        Object val = method.proceed()

        println("AnotherAspect: After Invoking Method");

        return val + " another updated value";
    }

}