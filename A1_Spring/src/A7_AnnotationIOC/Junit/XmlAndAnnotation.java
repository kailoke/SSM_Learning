package A7_AnnotationIOC.Junit;

import A7_AnnotationIOC.Domain.User;
import A7_AnnotationIOC.Service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * xml+基础annotation 测试DAO
 */

public class XmlAndAnnotation {
    private ApplicationContext ctx;

    @Before
    public void initCTX() {
        ctx = new ClassPathXmlApplicationContext("a7_AnnotationIOC.xml");
    }

    @Test
    public void findAll() {
        UserServiceImpl userServiceImpl = ctx.getBean("userServiceImpl", UserServiceImpl.class);
        List<User> all = userServiceImpl.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void find() {
        UserServiceImpl userServiceImpl = ctx.getBean("userServiceImpl", UserServiceImpl.class);
        User user = userServiceImpl.find(3L);
        System.out.println(user);
    }

    @Test
    public void update() {
        UserServiceImpl userServiceImpl = ctx.getBean("userServiceImpl", UserServiceImpl.class);
        User user = new User();
        user.setId(1);
        user.setName("李四");
        user.setAge(18);
        user.setGender("男");
        user.setTel("123");
        userServiceImpl.update((long) user.getId(), user);
    }
}