package A3_RequestData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/** @RequestHeader
 * 一、作用：映射请求头信息给HandlerMethod的形参赋值
 * 二、使用上基本和RequestParam相同，没有要求参数则抛出异常
 */

@Controller
public class A2_RequestHeader {
    @RequestMapping("/RequestHeader")
    public String requestHeader(@RequestHeader("Accept-Language")String lan){
        System.out.println("lan:" + lan);
        return "success";
    }
}
