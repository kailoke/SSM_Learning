package A5_DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * 引用外部文件
 * 通过spring类：PropertyPlaceholderConfigurer，指明location属性
 * 简化写法：命名空间context:property-placeholder，指明location属性
 *
 * spring语法：
 * classpath   :从当前工程src下寻找文件
 * classpath*  :从所有工程src下寻找文件
 */
public class DataSource {
    @Test
    // 直接配置
    public void directlySet() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a5_Spring-DataSource.xml");
        javax.sql.DataSource dataSource1 = ctx.getBean("dataSource1", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource1);
        System.out.println("Connection: " + dataSource1.getConnection());
    }

    @Test
    // IOC PropertyPlaceholder
    public void placeholder() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a5_Spring-DataSource.xml");
        javax.sql.DataSource dataSource2 = ctx.getBean("dataSource2", javax.sql.DataSource.class);
        System.out.println("DataSource: " + dataSource2);
        System.out.println("Connection: " + dataSource2.getConnection());
    }
}
