package A1_MakeBean;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的三种创建方式：
 * 一、无参构造函数
 *  > 若类中没有默认无参构造器，则构造失败并且抛出异常 BeanCreationException:No default constructor found
 *
 * 二、自定义工厂
 *  > 静态工厂，直接声明Bean的id，工厂类，及factory-method
 *  > 实例工厂，由Bean调用factory-method
 *      > 创建工厂Bean
 *      > 创建Bean，factory-bean && factory-method属性
 *
 * 三、Spring类：FactoryBean，实例工厂
 *  > 默认创建FactoryBean的实现类Bean
 *  > 默认factory-method为 getObject
 */
public class A2_MakeBean {
    @Test
    // 1.调用默认无参构造器
    public void defaultConstructor() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_MakeBean/a1_MakeBean.xml");
    }

    @Test
    // 2.工厂方法 factory-method
    public void factoryMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_MakeBean/a1_MakeBean.xml");
        Person tom = ctx.getBean("tom", Person.class);
        System.out.println(tom);
    }

    @Test
    // 3.FactoryBean
    public void factoryBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A1_MakeBean/a1_MakeBean.xml");
        Person jerry = ctx.getBean("jerry", Person.class);
        System.out.println(jerry);
    }
}

class TestFactoryBean implements FactoryBean<Person> {

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
