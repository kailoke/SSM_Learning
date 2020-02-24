package A4_ScopeAndLifeCycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 /**
 *  * Bean的生命周期
 *  * 一、SpringIOC容器可以管理Bean的生命周期，Spring允许在Bean的生命周期内特定时间点执行任务
 *  * 二、IOC对Bean的生命周期管理过程
 *  * > 1. 通过BeanFactory(构造器)或FactoryBean创建Bean实例
 *  * > 2. 为Bean的属性注入值或注入ref引用
 *  * > 3. init-method       调用Bean的初始化方法
 *  * > -- Bean -- 对象创建流程完毕
 * > 4. destroy-method    IOC关闭时，销毁所有Bean并执行Bean的销毁方法
 */

public class A2_LifeCycle {
    @Test
     public void lifeCycle() {
         ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a4_Spring-ScopeLifeCycle.xml");
         Car lifeCycle = ctx.getBean("lifeCycle", Car.class);
         System.out.println("使用Bean对象" + lifeCycle);

         // 关闭容器
         ctx.close();
     }
}
