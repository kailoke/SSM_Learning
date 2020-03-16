package A2_RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** @RequestMapping: 处理器映射器
 * 一、可注解的元素类型
 *  > TYPE  类，为Controller内 RequestMapping 指定根目录为：WEB根目录 + path
 *  > METHOD方法，在类映射路径基础上增加各自的"后缀"路径
 *
 * 二、映射请求的条件参数
 * > 0. name : 为此映射起名
 * > 1. value || path : 路径，习惯以'/'开始
 * > 2. method : 请求方法，参数使用RequestMethod枚举实例
 * > 3. headers : 请求头参数检查，支持简单表达式
 *  >  !(不含参数)，!=(参数不等于)，=(参数等于)
 * > 4. params : 请求体参数检查，支持简单表达式
 *  >  !(不含参数)，!=(参数不等于)，=(参数等于)
 */
@Controller
//@RequestMapping("/TypePath")   // ${contextPath}/SpringMVC/RequestMapping_ElementType
public class A1_RequestMapping {
    // 1. 修饰元素类型
    @RequestMapping(value = "/RequestMappingElementType")
    public String elementType (){
        return "success";
    }

    // 2.请求方法
    @RequestMapping(path = "/RequestMappingMethod",method = {RequestMethod.POST,RequestMethod.GET})
    public String method() {
        return "success";
    }

    // 3.映射请求的参数：不满足则返回400(错误请求)
    @RequestMapping(path = "/RequestMappingParams", params = {"username!=jerry","password","!gender"})
    public String params() {
        return "success";
    }

    // 4.映射请求的参数：不满足则返回400(错误请求)
    @RequestMapping(path = "/RequestMappingHeaders", headers = "!Accept-Language")
    public String header() {
        return "success";
    }
}
