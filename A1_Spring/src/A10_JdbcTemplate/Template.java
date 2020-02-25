package A10_JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate使用步骤
 */
public class Template {
    public static void main(String[] args) {
        // 定义数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///test?serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("root");

        // 1.获取对象
        JdbcTemplate jt = new JdbcTemplate(ds);
        // 2.执行操作
        jt.execute("insert into user values(null,'关羽',18,'男','444')");
    }
}
