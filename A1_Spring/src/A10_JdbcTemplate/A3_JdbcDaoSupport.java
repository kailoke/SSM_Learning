package A10_JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/** JdbcDaoSupport的使用
 * Dao实现类继承接口，获得父类jdbcTemplate属性并通过其getter访问
 * 获得父类的setDataSource()即可配置Bean:jdbcTemplate
 */
public class A3_JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    // 为jdbcTemplate提供两种注入方式
    // 1.注入已经带有 数据源 的jdbcTemplate
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 内部仅判断是否进行jdbcTemplate的初始化
    // 2.IOC仅管理数据源，由编程创建jdbcTemplate对象不由IOC管理
    public void setDataSource(DataSource dataSource) {
        if (jdbcTemplate == null && dataSource!=null) {
            createJdbcTemplate(dataSource);
        }
    }
    // 初始化 jdbcTemplate(DataSource)
    private void createJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
