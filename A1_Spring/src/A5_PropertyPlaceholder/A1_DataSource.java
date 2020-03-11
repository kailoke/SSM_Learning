package A5_PropertyPlaceholder;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/** 资源路径
 * 一、引用方式
 *  > 1.xmlBean   Spring..PropertyPlaceholderConfigurer>location
 *  > 2.xmlns     context:property-placeholder:location
 *  > 3.@PropertySource(value = {location...}
 *      > Spring高版本自带EL解析器
 *      > Spring低版本需要Bean:Spring..PropertyPlaceholderConfigurer占位符解析器
 *
 * 二、SpEL语法：
 *  > classpath   :从当前工程src下寻找文件
 *  > classpath*  :从所有工程src下寻找文件
 */
public class A1_DataSource {
    @Test
    // 1.直接配置
    public void directlySet() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A5_PropertyPlaceholder/Spring-DataSource.xml");
        javax.sql.DataSource dataSource1 = ctx.getBean("dataSource1", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource1);
        System.out.println("Connection: " + dataSource1.getConnection());
    }

    @Test
    // IOC PropertyPlaceholder
    public void placeholder() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A5_PropertyPlaceholder/Spring-DataSource.xml");
        javax.sql.DataSource dataSource2 = ctx.getBean("dataSource2", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource2);
        System.out.println("Connection: " + dataSource2.getConnection());
    }
}
