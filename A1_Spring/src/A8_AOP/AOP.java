package A8_AOP;

import A9_AOPAnnotation.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** SpringAOP
 * 一、AOP运行原理
 *  > Spring框架监控切入点方法的执行，一旦触发则使用代理机制动态创建目标对象的代理对象
 *    根据通知类别在代理对象的对应位置织入通知方法，并成完整的代码逻辑运行
 *  > 代理选择
 *      > 目标类若实现了接口则使用Proxy 基于接口的动态代理
 *      > 目标类未实现接口则使用Cglib   基于子类的动态代理
 *
 * 二、AOP术语
 *  > Target:代理对象代理的对象
 *  > Proxy :代理对象
 *  > Aspect:切面，"切入点" + "通知"
 *  > JoinPoint连接点：
 *  > PointCut切入点 ：对哪些连接点进行拦截的定义
 *  > Advice通知：拦截到切入点后执行的事情(切面方法)
 *      > 通知类型 + 通知方法
 *  > Weaving织入：将"切面"应用到目标对象创建新代理对象的过程
 *      > Spring采用动态代理织入，Proxy创建的代理对象是目标对象的接口类实例
 *      > AspectJ采用编译器织入和类装载期织入
 *
 * 三、切入点表达式 execution(↓↓↓↓)
 *  > 全路径： Modifier returnType packages.Class.method(argCLasses)
 *  > * 通配： (可省略) * *..*.*(..)
 *      > 包名:每个包名可使用一个*匹配，多个包需要多个包匹配；否则使用..表示当前包及其子包
 *      > 参数列表:
 *          > *  有任意参数
 *          > .. 有无任意参数
 *          > Class<T> clazz 参数类型
 *
 * 四、环绕通知(around) == invoke()，用以自定义切面内容
 *  > 切入点方法作为 ProceedingJointPoint 的实例
 *  > 环绕方法(ProceedingJointPoint pjp)，内部使用 pjp.proceed()调用切入点
 */

public class AOP {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("a8_Spring-AOP.xml");
        IUserService userService = ctx.getBean("userService", IUserService.class);

        userService.addUser();
    }
}
