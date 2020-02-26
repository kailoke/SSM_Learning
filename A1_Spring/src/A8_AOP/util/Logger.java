package A8_AOP.util;

/**
 * 记录日志的通知类
 */
public class Logger {
    // 前置通知
    public void before() {
        System.out.println("logger : 前置");
    }

    // 后置通知
    public void after() {
        System.out.println("logger : 后置");
    }

    // 异常通知
    public void catchEx() {
        System.out.println("logger : 异常");
    }

    // 最终通知
    public void finallyDo() {
        System.out.println("logger : 最终");
    }

    public Object around() {
        System.out.println("logger : 环绕");
        return null;
    }
}
