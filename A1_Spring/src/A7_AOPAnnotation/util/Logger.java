package A7_AOPAnnotation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/** 切面
 * 一、通知
 *  * JointPoint 连接点类，可直接在通知方法内声明连接点对象
 *      > 连接点对象包含连接点(全类名方法)信息
 *  1. @Before("切入点表达式")：前置通知，拦截到切入点后，在连接点执行前执行通知方法
 *      > try {..}
 *  2. @After                : 后置通知，在连接点方法执行返回值之前执行，且一定执行
 *      > finally {..}
 *  3. @AfterReturning()     : 返回通知，在连接点方法正常执行返回值之后执行(发生异常则不执行)
 *      > #returing=value 注解中声明目标方法的返回值绑定参数名
 *        通知方法中声明返回值参数，获得目标方法的返回值
 *  4. @AfterThrowing        : 异常通知，在连接点方法捕获到异常时执行
 *      > catch {..}
 *      > #throwing=value 注解中声明目标方法的异常返回值绑定参数名
 *        通知方法中声明异常，获得目标方法的异常对象
 *       !可通过异常类型指定发生特定异常时才执行 异常通知
 *
 *  5. @Around 环绕通知，自定义通知逻辑
 *      > 通知方法必须有返回值类型 Object
 *      > 通知方法参数必须有连接点对象：ProceedingJointPoint extends JointPoint，增加方法 proceed()执行目标对象的目标方法
 *      > try-catch-finally 块中自定义切面逻辑
 *
 * 二、切入点表达式
 *  > 1.修饰符可省略，*指明不限定的返回值类型
 *  > 2.一个包名可使用一个*代替
 *  > 3.类 && 方法名均可使用 * 代替
 *  > 4.参数列表
 *      基本类型  int double
 *      引用类型  java.lang.Integer
 *      有类型    *
 *      任意类型  ..(可有可无)
 *  > 5.切入点表达式的重用： @PointCut(execution()) 注解于空方法上，方法名为切入点名
 *      * 使用： @AdviceType("切入点方法名()")；不同包可使用全类方法名访问
 *
 * 三、切面优先级
 *  > @Order(int) 配置切面执行优先级：值越大优先级越低，默认值=Integer.Max_Value   0x7fffffff
 */
@Component("logger")
@Aspect()
public class Logger {
    @Pointcut("execution(* A7_AOPAnnotation.service.*.*(*))")
    private void pt1(){}

    @Before("pt1()")    // 前置通知
    public void before(JoinPoint jp) {
        // 获得方法参数
        Object[] args = jp.getArgs();
        System.out.println("前置通知before==>"
                + "args:" + Arrays.toString(args));
    }

    @After("pt1()")     // 后置通知
    public void after(JoinPoint jp) {
        System.out.println("后置通知after==>"
                + "signature.getName():" + jp.getSignature().getName());
    }

    // 返回通知，绑定目标方法的返回值并传入形参
    @AfterReturning(value = "execution(* A7_AOPAnnotation.service.UserServiceImpl.deleteUser(..))",
                    returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        System.out.println("返回通知AfterReturning==>"
                + "signature.getName():" + jp.getSignature().getName()
                + "\ttargetMethodReturn:" + result);
    }

    // 异常通知
    @AfterThrowing(value = "execution(* A7_AOPAnnotation.service.UserServiceImpl.updateUser(int))",
                    throwing = "e")
    public void catchEx(Exception e) {
        System.out.println("异常通知AfterThrowing==>"+
                "异常信息:" + e);
    }

    @Around("execution(* A7_AOPAnnotation.service.UserServiceImpl.selectUser(..))")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知Around==>");
        try {
            System.out.println("自定义 前置方法");

            Object proceed = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("自定义 异常方法");

            throwable.printStackTrace();
        } finally {
            System.out.println("自定义 后置方法");
        }
        return 1;
    }
}
