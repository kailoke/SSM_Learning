package A6_Autowire;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** autowire:自动装配引用对象
 * 一、xml配置特性：
 *  > 必须对全部引用属性进行装配
 *  > 仅能指定一个装配模式
 *
 * 二、装配模式
 *  > no        默认不装配，需要用户手动指定value | ref
 *  > byName    寻找IOC中bean的id值与 装配对象的属性名进行匹配，匹配成功则装配，否则为null
 *  > byType    寻找IOC中bean的类型“唯一”与装配对象的属性类型进行匹配
 *  > constructor   类似byType，但需要传入Class参数
 *  > autodetected  constructor匹配失败后进行byType匹配
 *
 * 三、注解配置特性：
 *  > @autowired：若byType匹配到多个后，按byName进行唯一匹配
 */

public class A0_Autowire {
    private ClassPathXmlApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("A6_Autowire/a6_Spring-Autowire.xml");
    }

    @Test
    public void autowireByName() {
        Person tom = ctx.getBean("tom1", Person.class);
        System.out.println(tom);
    }

    @Test
    public void autowireByType() {
        Person tom = ctx.getBean("tom2", Person.class);
        System.out.println(tom);
    }
}
