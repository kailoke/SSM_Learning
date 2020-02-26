package A9_AOPAnnotation;

import A9_AOPAnnotation.config.SpringConfig;
import A9_AOPAnnotation.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 一、xml开启aop注解  <aop:aspectj-autoproxy/>
 *      > Bean  @Component，IOC注册Bean
 *      > 切面  @Aspect
 *      > 切入点表达式(配置与方法上)
 *         | @Pointcut("execution()")
 *      > 通知(配置于方法上)
 *         | @before("pointcut()") @after-returning @after-throwing @after @around
 *
 * 二、注解开启aop注解 @EnableAspectJAutoProxy
 */

public class AOPAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        IUserService userService = ctx.getBean("userService", IUserService.class);

        userService.addUser();
    }
}
