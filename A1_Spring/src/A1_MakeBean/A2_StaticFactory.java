package A1_MakeBean;

/**
 * 模拟静态工厂创建Bean
 */
public class A2_StaticFactory {
    public static Person getPerson() {
        return new Person("tom");
    }
}
