package A2_XmlDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/** 注入 集合类型
 * > <list><set><array>
 *  > innerHtml:值(注入类型)
 *
 * > <map: entry>
 *  > entry: key||key-ref  value||value-ref
 */
public class A3_CollectionMapDI {
    private String name;
    private List<Car> cars;

    public A3_CollectionMapDI() {
    }

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A2_XmlDI/Spring-DI.xml");
        A3_CollectionMapDI list = ctx.getBean("list", A3_CollectionMapDI.class);
        System.out.println(list);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
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
