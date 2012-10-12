package apackage;




import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint

import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.aspectj.lang.annotation.*

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 30/7/12
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Aspect
@Component
public class LoggerInterceptor {

    def springSecurityService

    @Pointcut("within(com.service..*)")
    private void anyPublicOperation() {
    }


   /* @Before("anyPublicOperation()")
    public void checkUserForSecurity(JoinPoint joinPoint) throws Exception {
        User user = springSecurityService?.currentUser;
        println("user======" + user)
        if (!user) {
            //  5/0
        }

    }
*/
    /* @AfterThrowing
    public ModelAndView catchException(JoinPoint joinPoint, Throwable error){
        println("====errror======"+error)

    }*/

    @Before("anyPublicOperation()")
    public void logBefore(JoinPoint joinPoint) {
        //  new CheckForCompnent().fetchData();
        println("========springSecurityService========" + springSecurityService)
        String logMessage = String.format("Beginning method: %s.%s(%s)",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        System.out.println(logMessage);
    }

    @After("anyPublicOperation()")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("aftte");
    }


    @AfterReturning(pointcut = "within(com.service..*)", returning = "retVal")
    public void logAfterReturning(Object retVal) {

        System.out.println("REtrining:::::::::" + retVal);
        //  return retVal+"helo";
    }

    @Around("execution(* com.service.DefaultFooService.getFoo(String,int)) && args(name,age)")

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


   /* @Around("com.service.DefaultFooService.businessService()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        NullPointerException nullPointerException;
        while (numAttempts <= 2) {
            println("ateempt:::::::" + numAttempts)
            numAttempts++;
            try {
                return pjp.proceed();
            }
            catch (NullPointerException ex) {
                nullPointerException = ex;
            }
        }
        throw nullPointerException;
    }*/

}
