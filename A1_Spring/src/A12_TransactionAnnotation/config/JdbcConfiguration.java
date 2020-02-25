package A12_TransactionAnnotation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * jdbc配置类
 */
public class JdbcConfiguration {
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate creatJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource creatDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///test?serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
