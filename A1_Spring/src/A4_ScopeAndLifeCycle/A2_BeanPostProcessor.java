package A4_ScopeAndLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor
 * 一、功能：对IOC容器中所有的Bean都进行postProcess[Before/After]Initialization()方法调用
 * > xml中声明BeanPostProcessor对象，由IOC创建postProcessor实现类对象并管理其方法执行
 * 二、方法 Object method(Object,String)
 * > Object:当前对象
 * > String:当前对象的id
 * > Object:返回对象
 * 三、场景：
 * > BeforeInitialization，Bean创建后的信息检验
 * > AfterInitialization，Bean init-method后的信息检验
 */

public class A2_BeanPostProcessor implements BeanPostProcessor {

    @Override
    // 初始化前执行
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanProcessor before initialization");
        return o;


    }

    @Override
    // 初始化后执行
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanProcessor after initialization");
        return o;
    }
}
