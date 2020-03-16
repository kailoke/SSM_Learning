package A5_ResponseData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一、默认
 *  > HandlerMethod返回字符串类型的值会被当成逻辑视图名处理
 *
 * 二、返回 forward: || redirect: 前缀的字符串
 *  * SpringMVC 会对他们进行特殊处理：将 forward: 和 redirect: 当成指示符，其后的字符串作为 URL 来处理
 * > "redirect:xxx.jsp" ：会完成一个到 xxx.jsp 的重定向的操作
 *  > Dispatcher解析返回字符串得到RedirectViewResolver
 *    RedirectViewResolver解析RedirectView==>response.sendRedirect(url)
 */
@Controller
public class A3_RedirectView {
    @RequestMapping("/Redirect")
    public String redirect() {
        return "redirect:./redirect.jsp";
    }
}
