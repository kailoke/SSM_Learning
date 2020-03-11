package A2_XmlDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/** util命名空间
 * > 可重用的集合类型Bean
 *  > util:list
 *  > util:set
 *  > util:map
 *  > util:properties
 *  > util:constant
 */

public class A4_UtilDI {
    private String name;
    private Map<String, Car> map;

    // 测试方法
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A2_XmlDI/Spring-DI.xml");
        A4_UtilDI map = ctx.getBean("map", A4_UtilDI.class);
        System.out.println(map);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Car> getMap() {
        return map;
    }

    public void setMap(Map<String, Car> map) {
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
