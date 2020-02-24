package A2_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 引用 注入
 * <property name ref>
 */
public class A2_Person {
    private Integer id;
    private String name;
    private A1_Car car;

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a2_Spring-DI.xml");
        A2_Person person = ctx.getBean("zf", A2_Person.class);
        System.out.println(person);

        A2_Person gy = ctx.getBean("gy", A2_Person.class);
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

    public A1_Car getCar() {
        return car;
    }

    public void setCar(A1_Car car) {
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
