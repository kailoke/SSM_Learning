package A2_SpringMVCHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 处理器映射器的重载测试
 * > 方法签名：方法名 + 形参列表 构成，一般形参列表使用特殊字符代替参数类型
 * > Spring会在Handler调用前解析所有方法签名，并准备相应的方法参数
 * > Spring的方法签名很宽松，基本无限制
 */

@Controller
public class A2_MappingOverload {
    @RequestMapping(path = "/overload")
    public String restGET1() {
        System.out.println("overload no args");
        return "success";
    }
    @RequestMapping(path = "/overload", params = {"username"})
    public String restGET2() {
        System.out.println("overload require params");
        return "success";
    }
    @RequestMapping(path = "/overload", headers = "Accept-Language")
    public String restGET3() {
        System.out.println("overload2 require headers ");
        return "success";

    }
    @RequestMapping(path = "/overload/{id}")
    public String restGET4() {
        System.out.println("overload require REST URL");
        return "success";
    }
}
