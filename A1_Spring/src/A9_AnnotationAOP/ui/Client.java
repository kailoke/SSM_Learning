package A9_AnnotationAOP.ui;

import A9_AnnotationAOP.config.SpringConfig;
import A9_AnnotationAOP.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        // AspectJ默认调用Proxy创建的是代理类对象是原始类对象的接口类的
        IUserService userService = ctx.getBean("userService", IUserService.class);
        userService.addUser();
    }
}
