package A5_ResponseData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/** ModelAndView 模型和视图
 * 一、作用：存储handler执行处理后的数据
 * 二、WEB：Servlet处理后存放至域对象，转发至jsp页面，使用EL获取
 *
 * 三、生产数据，实现MVC解耦
 *  * HandlerAdapter的作用是为了生产ModelAndView对象(无论HandlerMethod返回任意信息，都将封装为MAV对象
 *  > 1. ModelAndView
 *      > Handler方法体通过该对象添加 model and view
 *      > 添加模型数据：
 *          ModelAndView addObject(String attributeName, Object attributeValue)
 *          ModelAndView addAllObject(Map<String, ?> modelMap)
 *      > 设置视图名称：return String || mv.setViewName(String) || mv.setView(View)
 *  > 2. Model
 *      > 内部使用了一个 org.springframework.ui.Model 接口存储模型数据
 *      > Spring MVC 在调用方法前会创建一个隐含的模型对象作为模型数据的存储容器
 *      > 若handlerMethod形参为(Model || Map)，Spring MVC 会将隐含模型的引用传递给这些入参
 *      * !!Map<String,Object>!! 泛型固定
 *
 * 四、解析输出
 *  > ViewResolver(多种资源解析器)通过ViewName解析出 View对象(可以是jsp\Excel\JFreeChar...)
 *  > 由View渲染模型数据(render() --> MergedOutputModel)，转发||重定向
 */

@Controller
public class A1_ModelAndView {
    // 1. ModelAndView
    @RequestMapping(path = "/ModelAndView")
    public ModelAndView modelAndView() {
        // 创建mav对象
        ModelAndView mav = new ModelAndView();
        // 1.增加模型数据
        mav.addObject("username","Admin");
        // 2.设置视图信息
        mav.setViewName("success");

        // 返回mav对象
        return mav;
    }

    // 2.Model
    @RequestMapping("/Model")
    public String model(Model model){
        model.addAttribute("loginMsg","用户名或者密码错误！");
        return "success";
    }

    // 3.Map
    @RequestMapping("/Map")
    // Spring创建map容器，传入映射方法内存储数据
    public String map(Map<String,Object> map) {
        System.out.println(map.getClass().getName());
        map.put("password","123456");
        return "success";
    }
}
