package A3_Relation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean关系：继承与依赖
 * 一、Parent
 *  > xml中使用parent声明父BeanID
 *  > abstract \ autowire 属性不会被继承
 *
 * 二、abstract
 *  > xml中使用 abstract=true 声明
 *  > Spring不会实例化 abstract Bean，内部声明属性 name-value 模板
 *  > abstract Bean没有Class，反而依靠继承BeanClass反向推理其类及属性
 *
 * 三、depends-on
 *  > Bean的实例化需要其依赖的Bean已经存在
 */

public class Relation {
    @Test
    public void parent() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A3_Relation/a3_Spring-Relation.xml");
        Address addr1 = ctx.getBean("addr1", Address.class);
        System.out.println(addr1);
        Address addr2 = ctx.getBean("addr2", Address.class);
        System.out.println(addr2);
    }

    @Test
    public void dependOn() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A3_Relation/a3_Spring-Relation.xml");
        Address depend = ctx.getBean("depend", Address.class);
        System.out.println(depend);
    }
}

// 继承 测试类
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
