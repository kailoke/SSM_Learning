package A2_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 注入 List集合
 */
public class A3_PersonList {
    private String name;
    private List<A1_Car> cars;

    public A3_PersonList() {
    }

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a2_Spring-DI.xml");
        A3_PersonList list = ctx.getBean("list", A3_PersonList.class);
        System.out.println(list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<A1_Car> getCars() {
        return cars;
    }

    public void setCars(List<A1_Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "A3_PersonList{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
