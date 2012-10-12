package net.thoughtforge.aspect;

import net.thoughtforge.task.TaskTimer;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public abstract class ProfilingAspect {

    private ProfilerThreadLocal profilerThreadLocal = new ProfilerThreadLocal();

    @Pointcut
    public abstract void profilingPointcut();
    
    @Around("profilingPointcut()")
    public Object doProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String taskName = createTaskName(proceedingJoinPoint);
        TaskTimer taskTimer = profilerThreadLocal.get();
        try {
        	taskTimer.start(taskName);

            return proceedingJoinPoint.proceed();
    	} finally {
    		taskTimer.stop();

    		if (taskTimer.getTaskCount() == 0) {
    		    doLogging(proceedingJoinPoint.getTarget().getClass(), taskTimer.printSummary());
    		    profilerThreadLocal.remove();
    		}
    	}
    }

    private String createTaskName(ProceedingJoinPoint proceedingJoinPoint) {
        return new StringBuffer(proceedingJoinPoint.getTarget().getClass().getName())
            .append(".")
            .append(proceedingJoinPoint.getSignature().getName())
            .toString();
    }

    private void doLogging(Class<? extends Object> clazz, String prettyPrint) {
    	LogFactory.getLog(clazz).info("\n\n" + prettyPrint + "\n");
    }

    private class ProfilerThreadLocal extends ThreadLocal<TaskTimer> {

        @Override
        protected TaskTimer initialValue() {
            return new TaskTimer(Thread.currentThread().getName());
        }
    }
}
