package A3_RequestData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** @RequestParam
 * 一、作用：映射请求参数至HandlerMethod形参赋值
 * 二、Servlet获取请求参数：
 *  > request.getParameter(key)
 *  > request.getParameterMap()存储所有参数至map
 *
 * 三、Spring获取请求参数
 *  > Spring存储参数KV至Map，通过@RequestParam(key)获取Value
 *  > 若注解内key和形参名相同，则可省略@RequestParam注解。(隐式，不推荐)
 *  > 属性
 *      > required:默认true，要求URL必须携带参数，否则抛出异常
 *      > defaultValue:默认null。注意基本类型!=null
 *
 */

@Controller
public class A1_RequestParam {
    @RequestMapping(path = "/RequestParam")
    public String requestParam(@RequestParam("username")String username,
                   @RequestParam(value = "password",required = false,defaultValue = "0") String password) {
        System.out.println("username: " + username);
        System.out.println("password:" + password);
        return "success";
    }
}
