package A9_JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/** 手写JdbcDaoSupport
 * > 作用：用户Dao类实现JdbcDaoSupport
 *  > 获得jdbcTemplate属性并通过getter()/setter()访问
 *  > 获得setDataSource()即可初始化JdbcTemplate(DataSource)对象
 */
public class A3_JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    // 1.jdbcTemplate注入方式以：直接注入jdbcTemplate(DataSource)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 内部进行jdbcTemplate的初始化
    // 2.IOC管理DataSource，自动装配jdbcTemplate(dataSource)
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
