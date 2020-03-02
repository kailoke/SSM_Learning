package A4_REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * REST风格的URL路径参数
 */
@Controller
public class A1_PathVariable {
    @RequestMapping(value = "RESTPathVariable/{username}/{password}")
    public String pathVariable(@PathVariable("username") String username, @PathVariable("password") String password) {
        System.out.println("解析到路径参数 username: " + username);
        System.out.println("解析到路径参数 password: " + password);
        return "success";
    }
}
