package A9_AOPAnnotation.util;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志的通知类
 */
@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* A9_AOPAnnotation.service.*.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void before() {
        System.out.println("logger : 前置");
    }

    @AfterReturning("pt1()")
    public void after() {
        System.out.println("logger : 后置");
    }

    @AfterThrowing("pt1()")
    public void catchEx() {
        System.out.println("logger : 异常");
    }

    @After("pt1()")
    public void finallyDo() {
        System.out.println("logger : 最终");
    }

//    @Around("pt1()")
//    public Object around() {
//        System.out.println("logger : 环绕");
//        return null;
//    }
}
