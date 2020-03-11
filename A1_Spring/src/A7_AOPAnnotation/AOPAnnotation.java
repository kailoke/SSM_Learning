package A7_AOPAnnotation;

import A7_AOPAnnotation.config.SpringConfig;
import A7_AOPAnnotation.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 一、注解切面的使用方式
 * > xml开启aop注解
 *  > xml启用切面注解 <aop:aspectj-autoproxy/>
 *  > 1.注入Bean : @Component，IOC注册Bean
 *  > 2.声明切面 : @Aspect，Bean作为切面
 *  > 3.切入点表达式(function)
 *      | @Pointcut("execution()")
 *        private void pointcut(){}
 *  > 4.通知注解(注解与通知方法)
 *      | @before("pointcut()")
 *      | @after-returning
 *      | @after-throwing
 *      | @after
 *      | @around
 *
 * > 注解开启aop注解
 *  > @EnableAspectJAutoProxy：为满足切面通知的被作用Bean生成代理
 *    * getBean("原始对象") --> 原始对象被通知作用(切入点) --> 返回代理对象
 */
public class AOPAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取代理对象 com.sun.proxy.$Proxy18
        // 代理对象的类型只能其父类接口
        IUserService userService = ctx.getBean("userServiceImpl", IUserService.class);
        System.out.println("代理对象：" + userService.getClass().getName());

        System.out.println("\n---测试环绕通知---");
        userService.selectUser();

        System.out.println("\n---通知测试---");
        userService.addUser(1);

        System.out.println("\n---测试获得目标方法返回值---");
        userService.deleteUser(10);

        System.out.println("\n---测试异常通知---");
        userService.updateUser(5);
    }
}
