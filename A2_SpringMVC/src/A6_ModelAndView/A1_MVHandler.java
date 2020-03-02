package A6_ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/** ModelAndView处理模型数据
 * 一、作用：服务端处理完模型数据后交予客户端进行显示(jsp显示)
 * 二、WEB：Servlet处理后存放至域对象，转发至jsp页面，使用EL获取
 * 三、生产数据
 *  > MappingHandler的作用是为了生产ModelAndView对象
 *  > 1. 封装模型数据
 *      > ModelAndView 对象数据封装
 *      > (Model)Map<String,Object> 对象数据封装：context.BindingAwareModelMap extends ModelMap implements Model
 *      > Model 对象数据封装
 *  > 2. 设置视图名称： return String || mv.setViewName()
 *
 * 四、解析输出
 *  > ViewResolver(多种资源解析器)通过ViewName解析出 View对象(可以是jsp\Excel\JFreeChar...)
 *  > 由View渲染模型数据(render() --> MergedOutputModel)，转发||重定向
 */

@Controller
public class A1_MVHandler {
    // 1. ModelAndView
    @RequestMapping(path = "/ModelAndView")
    public ModelAndView modelAndView() {
        // 创建mav对象
        ModelAndView mav = new ModelAndView();
        // 增加模型数据
        mav.addObject("username","Admin");
        // 设置视图信息
        mav.setViewName("success");

        // 返回mav对象
        return mav;
    }

    // 2.(Model)Map
    @RequestMapping("/Map")
    // Spring创建map容器，传入映射方法内存储数据
    public String map(Map<String,Object> map) {
        System.out.println(map.getClass().getName());
        map.put("password","123456");
        return "success";
    }

    // 3.Model
    @RequestMapping("/Model")
    public String model(Model model){
        model.addAttribute("loginMsg","用户名或者密码错误！");
        return "success";
    }
}
