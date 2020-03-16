package A1_HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一、控制器(Controller)
 * > 1. 处理器Bean，MVC-control层，使用@Controller声明为Bean + 控制器组件；
 *
 * > 2. HandlerAdapter：
 *      > HandlerMapping根据请求Url查找对应的HandlerAdapter
 *      > 编程方式：顶级接口HandlerAdapter:supports(Object handler){return:handler instanceof Controller}
 *          > 提供支持 执行实现Controller接口的方法
 *      > 执行Handler：ModelAndView HandlerAdapter.handle(HttpReq,HttpRsp);
 *
 * > 3. HandlerMapping处理器映射器
 *  > 使用@RequestMapping标识映射，对请求Url进行映射
 *      > 若成功则返回HandlerExecutionChain对象#handler + 多个#HandlerIntercetors
 *  > 编程方式：将Bean的name作为url进行查找（BeanNameUrlHandlerMapping)
 *
 * 二、ViewResolver 逻辑视图解析器
 *  > 解析各种逻辑视图(拼接字符串)，默认使用jsp解析器(jstl)
 *  > 返回物理视图View实例，进行转发操作
 *
 * 三、View 视图接口，实现类支持不同的View类型
 *  > 渲染模型数据(in ModelAndView对象)，填充到request域中
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
