package A3_RequestParameters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** Mapping RequestData
 * 一、作用：Spring MVC 通过分析处理方法的`签名`，HTTP请求信息绑定到处理方法的相应入参中
 *          映射请求`参数`给Handler_Method形参赋值
 *
 * 二、Servlet获取请求参数：
 *  > request.getParameter(key)
 *  > request.getParameterMap()存储所有参数至map
 *
 * 三、SpringMVC获取请求参数
 * > 1.原理
 *  > Spring存储参数KV至Map，通过@RequestParam(key)获取Value
 *  > 若注解内key和形参名相同，则可省略@RequestParam注解。(隐式，不推荐)
 * > 2.属性
 *      # required:默认true，要求URL必须携带参数，否则抛出异常
 *      # defaultValue：未传递参数时的默认值:default null
 *                  ==> 若映射为基本数据类型则必须指定非nullDefaultValue
 * > 3.可映射参数注解类型，作用于形参列表
 *  > RequestParam
 *  > RequestHeader
 *  > PathVariable
 *  > CookieValue
 */

@Controller
public class A1_MappingRequestData {
    @RequestMapping(path = "/RequestParam")
    // 1. Mapping @RequestParam
    public String requestParam(@RequestParam("username")String username,
                   @RequestParam(value = "password",required = false,defaultValue = "0") int password) {
        System.out.println("RequiredParam");
        System.out.println("mapped username:" + username);
        System.out.println("mapped password:" + password);
        return "success";
}

    @RequestMapping("/RequestHeader")
    // 2. Mapping @RequestHeader
    public String requestHeader(@RequestHeader("Accept-Language")String lan){
        System.out.println("mapped language:" + lan);
        return "success";
    }

    @RequestMapping("CookieValue")
    // 3. Mapping @CookieValue
    public String cookieValue(@CookieValue("JSESSIONID")String sessionID){
        System.out.println("mapped JSESSIONID:" + sessionID);
        return "success";
    }
}
