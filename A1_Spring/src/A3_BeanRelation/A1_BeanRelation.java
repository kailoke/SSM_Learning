package A3_BeanRelation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean关系：继承 || 依赖 || 抽象Bean
 * 一、Parent
 *  > xmlBean使用parent声明ParentBeanID
 *  > 子Bean会继承父类的部分属性，也可重写属性
 *  > abstract \ autowire 属性不会被继承
 *
 * 二、abstract
 *  > xmlBean使用 abstract=true 声明为抽象Bean属性模板
 *  > 不能指定class属性，依靠继承Bean的class属性反向推理抽象Bean的类型
 *  > IOC不会实例化abstractBean，内部声明属性可被子类继承
 *
 * 三、depends-on
 *  > Bean的实例化需要其依赖已经存在的Bean，实用性较小
 */

public class A1_BeanRelation {
    @Test
    // 1.继承关系
    public void parent() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A3_BeanRelation/Spring-Relation.xml");
        Address addr1 = ctx.getBean("addr1", Address.class);
        System.out.println(addr1);
        Address addr2 = ctx.getBean("addr2", Address.class);
        System.out.println(addr2);
    }

    @Test
    // 2.依赖关系
    public void dependOn() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A3_BeanRelation/Spring-Relation.xml");
        Address depend = ctx.getBean("depend", Address.class);
        System.out.println(depend);
    }
}

// Bean关系测试类
class Address {
    private String city;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
