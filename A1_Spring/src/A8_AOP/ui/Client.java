package A8_AOP.ui;

import A9_AnnotationAOP.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("a8_SpringAOP.xml");
        // AspectJ默认调用Proxy创建的是代理类对象是原始类对象的接口类的
        IUserService userService = ctx.getBean("userService", IUserService.class);
        userService.addUser();
    }
}
