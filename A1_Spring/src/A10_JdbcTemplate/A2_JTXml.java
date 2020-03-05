package A10_JdbcTemplate;

import A7_AnnotationIOC.Domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JdbcTemplate
 *  > update    增删改
 *  > query     查
 *      > RowMapper接口实现类，作用和ResultHandler相同。内部建立容器存储结果
 *  > queryForObject
 *      > 形参 Class<? extends Object> requiredType 传入返回类型
 *  > queryForList
 *  > queryForMap
 */
public class A2_JTXml {
    private JdbcTemplate jt = null;
    @Before
    public void init() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A10_JdbcTemplate/a10_Spring-JdbcTemplate.xml");
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
        Integer integer = jt.queryForObject("select count(*) from user", Integer.class);
        System.out.println("count(*) : " + integer);
    }
}
