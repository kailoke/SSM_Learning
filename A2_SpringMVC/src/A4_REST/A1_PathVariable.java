package A4_REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping使用{}将请求占位符参数绑定至操作方法形参
 * > @PathVariable 注解绑定形参
 */
@Controller
public class A1_PathVariable {
    @RequestMapping(value = "RESTPathVariable/{username}/{password}")
    public String pathVariable(@PathVariable("username") String username, @PathVariable("password") String password) {
        System.out.println("PathVariable Mapped username: " + username);
        System.out.println("PathVariable Mapped password: " + password);
        return "success";
    }
}
