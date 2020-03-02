package A6_ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用 redirect: 前缀进行重定向
 * > Dispatcher解析返回字符串得到RedirectView视图解析器
 * > RedirectView解析器解析Redirect视图，进行response.sendRedirect(url)
 */
@Controller
public class A3_RedirectView {
    @RequestMapping("Redirect")
    public String redirect() {
        return "redirect:./redirect.jsp";
    }
}
