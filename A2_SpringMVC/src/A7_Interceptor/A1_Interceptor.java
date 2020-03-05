package A7_Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 处理器拦截器
 * 一、定义形式
 *  > implements HandlerInterceptor
 *  > extends HandlerInterceptorAdapter
 *
 * 二、配置
 *  > SpringApplicationContext中 mvc:interceptors 维护Bean
 *  > 可配置全部拦截 或者 过滤拦截
 *
 * 三、方法
 *  > preHandle:DispatcherServlet调用mappedHandler前执行
 *  > postHandler:DispatcherServlet调用mappedHandler后、视图处理之前执行
 *  > afterCompletion:DispatcherServlet调用 视图输出数据，转发||重定向后执行
 *      > 某个preHandle 返回false    :InterceptorIndex逆序
 *      > 若DispatcherServlet发生异常:InterceptorIndex逆序
 */

@Component
public class A1_Interceptor implements HandlerInterceptor {

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
