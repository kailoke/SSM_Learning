package A10_JdbcTemplate;

import A7_AnnotationIOC.Domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JdbcTemplate使用步骤
 *
 * 结果集包装接口 RowMapper
 *  实现类:
 */
public class TemplateWithXml {
    JdbcTemplate jt = null;
    @Before
    public void init() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a10_SpringJdbcTemplate.xml");
        jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
    }

    @Test
    public void add() {
        jt.update("insert into user values(null,'刘备',22,'男','555')");
    }

    @Test
    public void queryOne() {
        List<User> query = jt.query("select * from user where id = ?",
                new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(query.isEmpty()?null:query.get(0));
    }

    @Test
    public void queryAll() {
        List<User> query = jt.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        for (User user : query) {
            System.out.println(user);
        }
    }

    @Test
    public void scalar() {

    }
}
