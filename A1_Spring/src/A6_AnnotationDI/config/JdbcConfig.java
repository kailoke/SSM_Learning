package A6_AnnotationDI.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 一、@Bean : 将被注解方法的返回值 向IOC注册Bean；和xml<Bean>等价
 *  **** IOC会对方法形参进行自动装配
 *  # String[] name  方法名为默认的BeanId
 *  # String[] value alias for name && name alias for value
 *  # Autowire autowire()
 *  # String initMethod()
 *  # String destroyMethod()
 *
 * 二、引用文件
 *  > @PropertySource，注解引用properties
 *  > @Value向属性注入 基本类型 || String，和xml配置方式类似
 */
@PropertySource("classpath:A6_AnnotationDI/config/druid.properties")
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
