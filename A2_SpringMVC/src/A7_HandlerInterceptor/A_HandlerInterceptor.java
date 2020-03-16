package A7_HandlerInterceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 处理器拦截器
 * 一、定义形式
 *  > implements HandlerInterceptor     Interceptor接口
 *  > extends HandlerInterceptorAdapter 适配器类
 *
 * 二、拦截方法
 *  > preHandle：DispatcherServlet调用mappedHandler前执行
 *      > 执行拦截后，若需要调用其他拦截器 || 处理器，则返回true
 *      > 否则返回false，不再调用其他的组件去处理请求
 *  > postHandler：DispatcherServlet调用mappedHandler后、视图处理之前执行
 *  > afterCompletion：DispatcherServlet调用 视图输出数据，转发||重定向后执行
 *
 * 三、多个拦截器的执行顺序
 *  > preHandle()，按拦截器配置顺序链式启用
 *      > 获取拦截器[]，迭代调用，存储正确调用的interceptorIndex
 *      > 返回值true则继续调用其他拦截器
 *      > 返回值false则结束DispatcherServlet，调用triggerAfterCompletion()
 *  > postHandler()
 *      > 获取拦截器[]，逆序调用(后置拦截器后逆序全执行)
 *  > afterCompletion()
 *      > 获取interceptorIndex，逆序调用（返回true的preHandle则执行其afterCompletion)
 *
 * 四、配置
 *  > 创建拦截器：<mvc:interceptors>
 *      > <ref> 引用一个存在的Bean作为拦截器
 *      > <bean>创建一个Bean作为拦截器
 *  > 配置拦截全部请求 || 路径过滤拦截
 *
 */
@Component
public class A_HandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor1 preHandler");
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor1 postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor1 afterCompletion");
    }
}
