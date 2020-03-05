package A2_DI;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DI依赖注入，Bean对象的赋值方式
 *
 * 一、Setter()
 * > set[name] in <property>
 *
 * 二、Constructor(args...)
 * > index：指定参数顺序
 * > type：指定参数"类"(Class)型
 *
 * 三、p命名空间
 * > <bean>属性 p:Xxx，依赖于setter
 *
 * 四、字面量在XML中的特殊字符
 * > 字符实体：&nbsp &lt &gt &eq
 * > 字符数据<![CDATA[""]]>，CharacterData中的数据将不使用XML解析器解析
 */
public class A1_CatTest {
    private static ApplicationContext ctx = null;

    @Before
    public void initIOC() {
        ctx = new ClassPathXmlApplicationContext("A2_DI/a2_Spring-DI.xml");
    }

    @Test
    // 1. set方法赋值Bean属性
    public void DIWithSetter() {
        A1_Car car1 = ctx.getBean("car1", A1_Car.class);
        System.out.println(car1);
    }

    @Test
    // 2. Constructor指定参数
    public void DIWithConstructor() {
        A1_Car car2 = ctx.getBean("car2", A1_Car.class);
        System.out.println(car2);
    }

    @Test
    // 3. p命名空间，依赖setter
    public void DIWithPNameSpace() {
        A1_Car car3 = ctx.getBean("car3", A1_Car.class);
        System.out.println(car3);
    }
}
