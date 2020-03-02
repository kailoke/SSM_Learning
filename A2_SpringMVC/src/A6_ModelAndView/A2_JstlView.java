package A6_ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图解析器：
 * 一、作用：将`逻辑视图`解析为具体的视图(View)对象
 * 二、解析器类型
 *  > 解析为Bean名字
 *      > BeanNameViewResolver
 *  > 解析为URL资源视图
 *      > InternalResourceView，默认类型
 *      > JstlView，若有jstl.jar则自动默认为此类型：JstlView extends InternalResourceView
 *      > RedirectView，通过MappingHandler返回值 redirect: 前缀将视图解析为转发视图
 *  > 解析为Excel || PDF
 *  > 解析为报表
 *  > 解析为Json
 *
 * 三、多个解析器的优先级
 *  > 通过属性 order 配置
 *  > Spring的order，int值越大优先级越低，默认为Integer.Max
 */

@Controller
public class A2_JstlView {
    @RequestMapping("/JstlView")
    public String jstlView() {
        System.out.println("JstlView Handler");
        return "success";
    }
}
