package A4_REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** REST风格的URL请求(方法)
 *
 * 一、HiddenHttpMethodFilter 增强请求方式
 *  > 实现原理：WEB过滤器，web.xml中配置，拦截请求并对获取POST请求参数_method，传递增强后的包装Request
 *             内部HttpServletRequest的内部实现子类保存_method并重写getMethod
 *  > 总结：method="POST" && _method in args
 *
 * 二、Handler
 *  > Handler重载不同method的方法映射，实现URL改变服务器状态
 *
 * 三、Tomcat权限保护
 *  > Tomcat默认WEB应用只读，需在Servlet中配置 readonly=false 开启写操作
 */
@Controller
public class A2_REST_method {
    // POST
    @RequestMapping(path = "/order", method = RequestMethod.POST)
    public String restPOST() {
        System.out.println("REST POST");
        return "success";
    }

    // GET
    @RequestMapping(path = "/order/{id}", method = RequestMethod.GET)
    public String restGET1(@PathVariable("id") Integer id) {
        System.out.println("REST get id: " + id);
        return "success";
    }

    // PUT
    @RequestMapping(path = "/order", method = RequestMethod.PUT)
    public String restPUT() {
        System.out.println("REST PUT");
//        return "redirect:/put";
        return "success";
    }
//    @RequestMapping(path = "/put")
//    public String restPut() {
//        System.out.println("rest put被重定向");
//        return "success";
//    }

    // DELETE
    @RequestMapping(path = "/order/{id}", method = RequestMethod.DELETE)
    public String restDELETE (@PathVariable("id") Integer id) {
        System.out.println("REST delete id:" + id);
//        return "redirect:/delete";
        return "success";
    }
//    @RequestMapping(path = "/delete")
//    public String restDelete() {
//        System.out.println("rest delete被重定向");
//        return "success";
//    }
}
