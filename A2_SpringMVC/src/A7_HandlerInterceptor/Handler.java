package A7_HandlerInterceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HandlerInterceptors测试控制器
 */
@Controller
public class Handler {
    @RequestMapping("/interceptors")
    public String interceptors(){
        System.out.println("mappedHandler processing");
        return "success";
    }
}
