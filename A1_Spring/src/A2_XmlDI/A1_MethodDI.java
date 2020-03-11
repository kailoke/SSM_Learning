package A2_XmlDI;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** DI依赖注入，给Bean对象属性注入值或依赖对象
 * 一、Setter()：调用一个setter方法
 * > <property: name value>
 *
 * 二、Constructor(args...)：声明一个构造参数
 *  : value || ref
 *  : name || index
 *  : type：指定参数"类"(Class)型
 *
 * 三、p命名空间
 * > <bean>属性 p:Xxx，实际是Setter()
 *
 * 四、字面量在XML中的特殊字符
 * > 字符实体：&nbsp &lt &gt &eq
 * > 字符数据<![CDATA[""]]>，CharacterData中的数据将不使用XML解析器解析
 *
 * 五、注入null值，innerHtml = <null/>
 *   * 注意 value = null 语法错误；"null"为字符串
 */
public class A1_MethodDI {
    private static ApplicationContext ctx = null;

    @Before
    public void initIOC() {
        ctx = new ClassPathXmlApplicationContext("A2_XmlDI/Spring-DI.xml");
    }

    @Test
    // 1. set方法赋值Bean属性
    public void DIWithSetter() {
        Car car1 = ctx.getBean("car1", Car.class);
        System.out.println(car1);
    }

    @Test
    // 2. Constructor指定参数
    public void DIWithConstructor() {
        Car car2 = ctx.getBean("car2", Car.class);
        System.out.println(car2);
    }

    @Test
    // 3. p命名空间，实际Setter()
    public void DIWithPNameSpace() {
        Car car3 = ctx.getBean("car3", Car.class);
        System.out.println(car3);
    }
}

// CarDI测试类
class Car {
    private String brand;
    private String corp;
    private Double price;

    public Car() {
        System.out.println("Constructor()... invoked");
    }

    public Car(String brand, String corp, Double price) {
        System.out.println("Constructor(s,s,d)... invoked");
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand(): " + brand);
        this.brand = brand;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        System.out.println("setCorp(): " + corp);
        this.corp = corp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        System.out.println("setPrice(): " + price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                '}';
    }
}
