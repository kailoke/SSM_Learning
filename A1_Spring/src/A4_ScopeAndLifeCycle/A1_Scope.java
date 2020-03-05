package A4_ScopeAndLifeCycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Bean的作用域
 * 一、scope = singleton
 * > 单例Bean，IOC容器创建时实例化singletonBean
 * > 单例Bean在IOC容器是单例的，getBean时获取单例Bean的引用
 *
 * 二、scope = prototype
 * > 原型Bean，IOC容器创建时不会实例化
 * > 每次getBean时创建原型Bean的实例并返回
 *
 * 三、Scope in "WebApplicationContext"
 * > request:每次请求创建新Bean对象
 * > session:每次会话创建新Bean对象
 * > globalSession:一次全局会话(多个服务器之间)
 */

public class A1_Scope {
    @Test
    // 一、单例Bean
    public void singletonBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A4_ScopeAndLifeCycle/a4_Spring-ScopeLifeCycle.xml");
//        Car singleton1 = ctx.getBean("singleton", Car.class);
//        Car singleton2 = ctx.getBean("singleton", Car.class);
//        System.out.println(singleton1 == singleton2);   // true
    }

    @Test
    // 二、原型Bean
    public void prototype() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A4_ScopeAndLifeCycle/a4_Spring-ScopeLifeCycle.xml");
        Car prototype1 = ctx.getBean("prototype", Car.class);
        Car prototype2 = ctx.getBean("prototype", Car.class);
        System.out.println(prototype1 == prototype2);   // false
        System.out.println(prototype1.equals(prototype2));   // false
    }
}
