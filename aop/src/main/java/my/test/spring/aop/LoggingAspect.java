package my.test.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int my.test.spring.aop.ArithmeticCalculator.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method '" + methodName + "' begins with " + args);
    }

    @After("execution(public int my.test.spring.aop.ArithmeticCalculator.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method '" + methodName + "' ends");
    }

    @AfterReturning(pointcut="execution(public int my.test.spring.aop.ArithmeticCalculator.*(int, int))",
            returning="result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method '" + methodName + "' returns " + result);
    }
//
//    /**
//     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
//     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
//     * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
//     */
//	@Around("execution(public int my.test.spring.aop.ArithmeticCalculator.*(int, int))")
//	public Object aroundMethod(ProceedingJoinPoint pjd){
//
//		Object result = null;
//		String methodName = pjd.getSignature().getName();
//
//		try {
//			//前置通知
//			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
//			//执行目标方法
//			result = pjd.proceed();
//			//返回通知
//			System.out.println("The method " + methodName + " ends with " + result);
//		} catch (Throwable e) {
//			//异常通知
//			System.out.println("The method " + methodName + " occurs exception:" + e);
//			throw new RuntimeException(e);
//		}
//		//后置通知
//		System.out.println("The method " + methodName + " ends");
//
//		return result;
//	}
}
