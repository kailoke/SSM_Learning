package A5_DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/** 引用外部文件
 * 一、引用方式
 *  > xml：xmlns context:property-placeholder，指明location属性
 *  > 注解：@ResourceSource(value = {location...}，Spring高版本自带EL解析器
 *      > Spring类：PropertyPlaceholderConfigurer占位符解析器Bean
 *          > return new PropertyPlaceHolderConfigurer()
 *          > location由注解指定
 *
 * 四、SpEL语法：
 *  > classpath   :从当前工程src下寻找文件
 *  > classpath*  :从所有工程src下寻找文件
 */
public class DataSource {
    @Test
    // 直接配置
    public void directlySet() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A5_DataSource/a5_Spring-DataSource.xml");
        javax.sql.DataSource dataSource1 = ctx.getBean("dataSource1", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource1);
        System.out.println("Connection: " + dataSource1.getConnection());
    }

    @Test
    // IOC PropertyPlaceholder
    public void placeholder() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A5_DataSource/a5_Spring-DataSource.xml");
        javax.sql.DataSource dataSource2 = ctx.getBean("dataSource2", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource2);
        System.out.println("Connection: " + dataSource2.getConnection());
    }
}
