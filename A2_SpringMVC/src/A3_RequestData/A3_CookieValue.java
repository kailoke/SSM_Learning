package A3_RequestData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/** @CookieValue
 * 一、作用：映射Cookie信息至HandlerMethod形参赋值
 *
 */
@Controller
public class A3_CookieValue {
    @RequestMapping("CookieValue")
    public String cookieValue(@CookieValue("JSESSIONID")String sessionID){
        System.out.println("JSESSIONID:" + sessionID);
        return "success";
    }
}
