package A10_JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** JdbcTemplate：Spring对JDBC的轻量封装
 * 一、使用流程
 *  > 获取对象(DataSource)
 *  > 执行操作(无数据源则传入Connection)
 *
 * 二、Attention
 *  > DataAccessException，Spring-core包定义并且处理
 *
 * 三、JdbcDaoSupport
 *  > 内部维护 JdbcTemplate 属性，提供jdbcTemplate对象的 get() && setDataSource初始化方法
 */
public class A1_JdbcTemplate {
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
