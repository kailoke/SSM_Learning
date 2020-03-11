package A1_IOC;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 创建Bean的两种规则
 * 一、InstantLoad
 * > ApplicationContext，读取xml配置后立即创建Bean
 * > 子类：ClassPathXml ApplicationContext
 * > 子类：FileSystemXml ApplicationContext
 *  * ApplicationContext的实现类均在初始化使即完成XML读取、解析、Bean的创建
 *
 * 二、LazyLoad
 * > BeanFactory，使用时创建Bean
 * > BeanFactory提供的是IOC容器的实现规范，顶级接口面向Spring框架
 */
public class A1_CreateRule {
    @Test
    // ApplicationContext
    public void instantLoad() {
        // xml解析后已经创建所有Bean
        ApplicationContext ctx = new ClassPathXmlApplicationContext("A1_IOC/MakeBean.xml");
    }

    @Test
    // BeanFactory
    public void lazyLoad() {
        Resource resource = new ClassPathResource("A1_IOC/MakeBean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        Person person = beanFactory.getBean("person", Person.class);
    }
}
