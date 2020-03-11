package A4_ScopeAndLifeCycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Bean的生命周期，受Scope属性影响
 *
 * 一、SpringIOC容器可以管理Bean的生命周期，Spring允许在Bean的生命周期内特定时间点执行任务
 *
 * 二、IOC对Bean的生命周期管理
 *  * 单例 || 原型
 *  > 1. 通过BeanFactory或FactoryBean创建Bean实例
 *      > 单例Bean在IOC创建时创建
 *      > 原型Bean在Bean被推送时创建
 *  > 2. 为Bean注入属性
 *  > 3. BeanPostProcessor.BeforeInitialization()
 *
 *  > 4. :init-method：调用Bean的初始化方法
 *  > 3. BeanPostProcessor.AfterInitialization()
 *
 *  > -- Bean -- 对象创建流程完毕
 *
 *  > 5. :destroy-method
 *      > 单例：IOC关闭时，销毁所有Bean并执行Bean的销毁方法
 *      > 原型：GC回收
 */

public class A2_LifeCycle {
    @Test
    public void lifeCycle() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A4_ScopeAndLifeCycle/Spring-ScopeLifeCycle.xml");
        Car lifeCycle = ctx.getBean("lifeCycle", Car.class);
        System.out.println("使用Bean对象" + lifeCycle);

        // 关闭容器
        ctx.close();
    }
}
