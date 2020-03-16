package A4_REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** REST：Representational State Transfer 表现层状态转化
 * 一、HiddenHttpMethodFilter
 *  > 实现原理：
 *      > 1.doFilterInternal()获取method="POST"的请求参数'_method'
 *      > 2.内部静态类 new HttpServletRequestWrapper(request,method)保存_method，重写getMethod()返回此值
 *  > 要点：form_method="POST" && RequestWrapper(request,_method)被过滤器增强后传递
 *
 * 二、RequestMapping_method
 *  > 同名且不同method的映射信息以根据不同请求方法执行对应的处理方法
 *
 * 三、操作方法
 *  > get   |Retrieve/arg
 *  > post  |Create
 *  > put   |Update
 *  > delete|Delete/arg
 *
 * 四、Tomcat默认关闭服务器·写·操作
 *  > Tomcat默认WEB应用只读，需要TomcatDefaultServlet配置 readonly=false
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
