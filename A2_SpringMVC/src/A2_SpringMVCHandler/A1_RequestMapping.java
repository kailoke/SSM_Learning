package A2_SpringMVCHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** @RequestMapping: 处理器映射器
 * 一、注解可用的元素类型
 *  > TYPE  类，为处理器内 RequestMapping+ViewHandler解析 指定根目录为：WEB根目录 + value
 *  > METHOD方法，在类映射路径基础上增加各自的"后缀"路径
 */

@Controller
//@RequestMapping("/SpringMVC")   // ${context}/SpringMVC/RequestMappingElementType
public class A1_RequestMapping {
    // 1. 修饰元素类型
    @RequestMapping(value = "/RequestMappingElementType")
    public String elementType (){
        return "success";
    }

    // 2.请求方式
    @RequestMapping(path = "RequestMappingMethod",method = {RequestMethod.POST,RequestMethod.GET})
    public String method() {
        return "success";
    }

    // 3.指定请求携带的参数，不满足则不能访问  !(不包含参数)，!=(参数不等于)，=(参数等于)
    @RequestMapping(path = "RequestMappingParams", params = {"username!=jerry","password","!gender"})
    public String params() {
        return "success";
    }

    // 4.指定请求携带的请求头信息，不满足则不能访问
    @RequestMapping(path = "RequestMappingHeaders", headers = "!Accept-Language")
    public String header() {
        return "success";
    }


}
