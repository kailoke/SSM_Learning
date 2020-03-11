package A8_AOPXml.util;

/**
 * 记录日志的通知类
 */
public class Logger {
    // 前置通知
    public void before() {
        System.out.println("logger : 前置");
    }

    // 后置通知
    public void finallyDo() {
        System.out.println("logger : 后置");
    }

    // 返回通知
    public void afterReturning() {
        System.out.println("logger : 返回");
    }

    // 异常通知
    public void catchEx() {
        System.out.println("logger : 异常");
    }
}
