package A1_HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 请求处理器
 * > 1. HandlerAdapter：由DispatcherServlet默认装配
 *  > 处理器适配器，使用@Controller组件标识；
 *  > 编程方式：顶级接口HandlerAdapter，supports():return handler instanceof Controller
 *      > handler(HttpReq,HttpRsp):return ModelAndView
 * > 2. HandlerMapping
 *  > 处理器映射器，使用@RequestMapping
 *  > 编程方式：将Bean的name作为url进行查找（BeanNameUrlHandlerMapping)
 *
 * 二、ViewResolver
 *  > 解析jsp解析，默认使用jstl
 */

@Controller
public class SpringMVCHandler {

    /**
     * 处理客户端请求：http://localhost:8080/SpringMVC/hello
     * @RequestMapping: HandlerMapping:完成请求与对应处理方法的映射
     *                  value是相对于WEB应用根目录的匹配字符串，不是路径
     * @return 请求处理方法返回的 infix 路径，由视图解析器拼接为最终转发路径
     */
    @RequestMapping(value = "hello")
    public String handlerHello() {
        System.out.println("Hello SpringMVC Handler Processing");
        return "success";   // 转发至ViewResolver: prefix + retVal + suffix
    }
}
