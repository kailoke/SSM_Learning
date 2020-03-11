package A6_AnnotationDI.Junit;

import A6_AnnotationDI.Domain.User;
import A6_AnnotationDI.Service_Autowired.UserServiceImpl;
import A6_AnnotationDI.config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 全注解注入依赖，测试DAO
 */

public class T2_Annotation {
    private ApplicationContext ctx;

    @Before
    public void initCTX() {
        // AnnotationIOC读取configuration类的字节码进行Bean解析
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
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