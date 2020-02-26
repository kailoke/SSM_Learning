package A7_AnnotationIOC.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 一、@Bean : 将修饰方法的返回值 向IOC注册Bean，可指定和xml中相同的属性
 *  > String[] name  方法名为默认的BeanId
 *  > String[] value alias for name && name alias for value
 *  > Autowire autowire()
 *  > String initMethod()
 *  > String destroyMethod()
 *  **** IOC会对方法形参进行自动装配
 *
 * 二、引用文件
 *  > xml引用properties:  <context:property-placeholder>
 *  > 注解引用properties: @PropertySource
 */

@PropertySource("classpath:A7_AnnotationIOC/config/druid.properties")
public class JdbcConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "runner")
    public QueryRunner getQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public javax.sql.DataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
