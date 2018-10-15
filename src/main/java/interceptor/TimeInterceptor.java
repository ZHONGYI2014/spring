package interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 计算方法执行时间的aop切面
 * 使用 @Aspect 注解的类, spring 会把它当作一个特殊的Bean （一个切面）, 也就是不会对这个类进行动态代理
 */
@Aspect
@Component
public class TimeInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    private static final long ONE_MINUTE = 60000;

    private static final String myPOINT = "execution(* service.impl.*.*(..))";

    @Around(myPOINT)
    public Object timeAround(ProceedingJoinPoint joinPoint) {

        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计方法执行时间环绕通知error",e);
        }

        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        //打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    /**
     * 打印方法执行时间
     * @param methodName
     * @param startTime
     * @param endTime
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.info(methodName + " 方法执行耗时: " + diffTime + " ms");
        if (diffTime > ONE_MINUTE) {
            logger.warn("------" + methodName + " 方法执行耗时: " + diffTime + " ms");
        }
    }

}
