package A1_MakeBean;

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
 *
 * 二、LazyLoad
 * > BeanFactory，使用时创建Bean
 */
public class A1_CreateRule {
    @Test
    // ApplicationContext
    public void instantLoad() {
        // xml解析后已经创建所有Bean
        ApplicationContext ctx = new ClassPathXmlApplicationContext("a1_MakeBean.xml");
    }

    @Test
    // BeanFactory
    public void lazyLoad() {
        Resource resource = new ClassPathResource("a1_MakeBean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        Person person = beanFactory.getBean("person", Person.class);
    }
}
