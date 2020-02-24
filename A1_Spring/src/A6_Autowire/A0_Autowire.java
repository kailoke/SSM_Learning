package A6_Autowire;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * autowire:自动装配引用对象
 * 一、xml配置特性：
 *  > 必须对全部引用属性进行装配
 *  > 仅能指定一个装配方式
 * 二、byName：
 * > 寻找IOC中bean的id值与 装配对象的属性名进行匹配，匹配成功则装配，否则为null
 * 三、byType:
 * > 寻找IOC中bean的类型“唯一”与装配对象的属性类型进行匹配
 */

public class A0_Autowire {
    private ClassPathXmlApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("a6_Spring-Autowire.xml");
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
