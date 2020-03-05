package A7_Interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class handler {
    @RequestMapping("/interceptors")
    public String interceptors(){
        System.out.println("mappedHandler processing");
        return "success";
    }
}
