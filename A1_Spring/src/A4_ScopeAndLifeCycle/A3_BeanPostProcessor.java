package A4_ScopeAndLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/** BeanPostProcessor:Bean后置处理器
 * 一、功能：对IOC容器中所有的Bean都进行postProcess(Before/After)Initialization()方法调用
 * > xml中声明BeanPostProcessor实现类Bean，由IOC创建并注册PostProcessorBean，管理其方法调用
 *
 * 二、public Object method(Object o,String s)
 * > 返回值Object：返回新的或修改后的Bean对象
 * > Object o：正在初始化的Bean
 * > String s：正在初始化Bean的Id(key)
 *
 * 三、场景：
 * > BeforeInitialization，Bean创建后的信息检验
 * > AfterInitialization，Bean init-method后的信息检验
 */

public class A3_BeanPostProcessor implements BeanPostProcessor {

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
