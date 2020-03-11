package A1_IOC;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的三种创建方式：
 * 一、无参构造函数(JavaBean)
 *  > 若类中没有默认无参构造器，则构造失败并且抛出异常 BeanCreationException:No default constructor found
 *
 * 二、自定义工厂
 *  > 静态工厂，Spring声明工厂Bean及其静态方法.factory-method
 *  > 实例工厂，由.factory-bean调用.factory-method
 *
 * 三、Spring类：FactoryBean，实例工厂
 *  > 默认创建FactoryBean的实现类Bean
 *  > 默认.factory-method:getObject()
 */
public class A2_MakeBean {
    @Test
    // 1.调用默认无参构造器
    public void defaultConstructor() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_IOC/MakeBean.xml");
    }

    @Test
    // 2.工厂方法 factory-method
    public void factoryMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_IOC/MakeBean.xml");
        Person tom = ctx.getBean("tom", Person.class);
        System.out.println(tom);
    }

    @Test
    // 3.Spring..FactoryBean
    public void factoryBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_IOC/MakeBean.xml");
        Person jerry = ctx.getBean("jerry", Person.class);
        System.out.println(jerry);
    }
}

// 2.静态工厂
class StaticFactory {
    public static Person getPerson() {
        return new Person("tom");
    }
}

// 3.Spring..FactoryBean
class FactoryBeanTest implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        return new Person("jerry");
    }

    @Override
    public Class<Person> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
