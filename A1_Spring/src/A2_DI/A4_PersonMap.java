package A2_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 注入 Map
 * util命名空间：MapBean<util:map>
 */
public class A4_PersonMap {
    private String name;
    private Map<String, A1_Car> map;

    public A4_PersonMap() {
    }

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A2_DI/a2_Spring-DI.xml");
        A4_PersonMap map = ctx.getBean("map", A4_PersonMap.class);
        System.out.println(map);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, A1_Car> getMap() {
        return map;
    }

    public void setMap(Map<String, A1_Car> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "A4_PersonMap{" +
                "name='" + name + '\'' +
                ", map=" + map +
                '}';
    }
}
