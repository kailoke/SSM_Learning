package A2_XmlDI;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 自动装配Bean的引用对象属性
 * 一、xml配置特性： <bean: autowire ..>
 *  > 必须对Bean的全部引用对象属性进行装配
 *  > Bean只能指定一个装配模式
 *
 * 二、装配模式(4)
 *  > no        默认不装配，需要用户手动指定 value || ref
 *  > byType    byFieldType，在container中匹配唯一类型注入依赖对象，使用Setter()注入属性
 *  > byName    byFiledName，在container中匹配唯一BeanId注入依赖对象
 *  > constructor   功能和byType类似，也是通过类型查找依赖对象；使用constructor()注入属性;
 *    * constructor-arg会覆盖此装配模式，实际上constructor-arg是constructor自动装配模式的显示声明
 *
 * 三、注解配置特性：
 *  > @autowired：若byType匹配到多个后，按byName进行唯一匹配
 */
public class A5_Autowire {
    private ClassPathXmlApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("A2_XmlDI/Spring-Autowire.xml");
    }

    @Test
    public void autowireByType() {
        Person tom = ctx.getBean("byTypeTom", Person.class);
        System.out.println(tom);
    }

    @Test
    public void autowireByName() {
        Person tom = ctx.getBean("byNameTom", Person.class);
        System.out.println(tom);
    }
}

// 自动装配测试类
class Person {
    private String name;
    // 对象引用，配置自动装配
    private Car car;
    // 对象引用，配置自动装配
    private Address addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", addr=" + addr +
                '}';
    }
}

// 被自动装配的测试类1
class Address {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

