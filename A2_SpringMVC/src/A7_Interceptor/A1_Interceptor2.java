package A7_Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个拦截器的执行顺序
 *  > preHandle()，按拦截器配置顺序链式启用
 *      > 获取拦截器[]，迭代调用，存储正确调用的interceptorIndex
 *      > 返回值true则继续调用其他拦截器
 *      > 返回值false则结束DispatcherServlet，调用triggerAfterCompletion()
 *  > postHandler()
 *      > 获取拦截器[]，逆序调用
 *  > afterCompletion()
 *      > 获取interceptorIndex，逆序调用（返回true的preHandle则执行其afterCompletion)
 */

public class A1_Interceptor2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor2 preHandler");
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor2 postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor2 afterCompletion");
    }
}
