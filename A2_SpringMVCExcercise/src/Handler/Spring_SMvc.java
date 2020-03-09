package Handler;

import Dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/** SpringIOC + SpringMVC
 * 一、原理
 *  > 通过contextListener监听Context的创建，在其contextInitialized()中初始化 WebApplicationContext实例并存储至ServletContext域中
 *  > 通过WebApplicationContextUtils工具类获取 SpringIOC 对象：WebApplicationContext
 *  > ApplicationContext的生命周期与ServletContext的生命周期联系起来
 *      可以使用getServletContext（）方法从WebApplicationContext获取ServletContext
 * 二、配置
 *  > <listener-class>ContextLoaderListener</listener>
 *  > <context-param> 监听器读取context初始化参数用以初始化IOC容器 </context-param>
 *
 * 三、组件扫描，use-default-filters = false
 *  > SpringIOC:   <context:exclude-filter type=annotation expression="@Annotation">
 *  > SpringMVC:    <context:include-filter type=annotation expression="@Annotation">
 */
@Controller
public class Spring_SMvc {
    @RequestMapping("Spring_SpringMVC")
    public String springSpringMVC(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserDao userDao = ctx.getBean("userDao", UserDao.class);
        System.out.println(userDao);
        return "success";
    }
}
