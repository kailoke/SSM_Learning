package A5_ResponseData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一、ViewResolver 视图解析器
 *  > 1.作用：将`逻辑视图`解析为具体的视图(View)对象
 *      > 视图对象由视图解析器负责实例化。由于视图是无状态的，所以他们不会有线程安全的问题   // todo ?视图是无状态的，不会有线程安全问题?
 *  > 2.视图解析器实现类
 *      > 解析为Bean的名字    BeanNameViewResolver
 *      > 解析为URL视图
 *          > InternalResourceViewResolver
 *          > JasperReportsViewResolver，基于java的开源报表工具
 *      > 解析为文件视图
 *          > FreeMarkerViewResolver，基于FreeMarker模板技术的模板文件
 *          > VelocityViewResolver
 *          > VelocityLayoutViewResolver，基于Velocity模板技术的模板文件
 *  > 3.视图解析的混用
 *      > 执行顺序： #order 配置。int值越大优先级越低，默认为Integer.Max
 *      > SpringMVC按`视图解析器优先顺序`对逻辑视图名进行解析，知道解析成功并返回View对象，否则抛出异常
 *
 * 二、View
 *  > 1.作用：渲染数据 render(Map<String,?>,HttpServletRequest,HttpServletResponse)，将MV的数据遍历至requestScope
 *            doDispatch():页面转发 || 重定向
 *  > 2.视图实现类
 *    > URL视图
 *      > InternalResourceView  默认类型，是InternalResourceViewResolver默认使用的视图实现类
 *      > JstlView  若有Jstl.jar，SpringMVC会自动将InternalResourceView转为JstlView
 *      > RedirectView，通过MappingHandler返回值 redirect: 前缀将视图解析为转发视图
 *    > 文档视图：AbstractExcelView || AbstractPdfView
 *    > 报表视图 JasperReports...
 *    > Json视图 MappingJacksonView
 */
@Controller
public class A2_View_Resolver {
    @RequestMapping("/JstlView")
    public String jstlView() {
        System.out.println("JstlView Handler");
        return "success";
    }
}
