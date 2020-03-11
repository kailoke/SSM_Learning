package A2_XmlDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 引用类型 注入
 *  1. <property: name ref>
 *  2. <property: name>
 *          <bean>匿名Bean || List || Map ...</bean>
 *      </property:>
 */
public class A2_RefDI {
    private Integer id;
    private String name;
    private Car car;

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A2_XmlDI/Spring-DI.xml");
        A2_RefDI person = ctx.getBean("zf", A2_RefDI.class);
        System.out.println(person);

        A2_RefDI gy = ctx.getBean("gy", A2_RefDI.class);
        System.out.println(gy);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "A2_Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
