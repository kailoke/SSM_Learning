package A9_JdbcTemplate;

import A6_AnnotationDI.Domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/** JdbcTemplate工具方法
 *  * 整体功能和JdbcUtils工具包类似analogous
 * 一、方法
 *  1. 增删改  ：update
 *  2. 批量更新：batchUpdate(String sql,List<Object[]>)
 *      > 每条Sql语句的参数封装为 Object[]
 *      > 所有参数封装为 List<Object[]>
 *
 *  3. 行查询  ：query
 *      > RowMapper接口实现类，作用和ResultHandler相同。内部建立容器存储结果
 *
 *  4. 标量(对象)查询 ：queryForObject 返回单个对象
 *      > 形参 Class<? extends Object> requiredType 传入返回类型
 *
 *  5. queryForList：查询结果封装为List
 *  6. queryForMap : 查询结果封装为Map
 *
 * 二、封装数据接口
 *  > 顶级接口：RowMapper
 *  > 实现类：
 *      > BeanPropertyRowMapper : 对象封装
 */
public class A2_JdbcTemplateXml {
    // JdbcTemplate初始化
    private JdbcTemplate jt = null;
    @Before
    public void init() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A9_JdbcTemplate/Spring-JdbcTemplate.xml");
        jt = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
    }

    @Test
    // 1. update()
    public void add() {
        jt.update("insert into user values(null,'小刘',22,'男','555')");
    }

    @Test
    // 2. (单)行查询
    public void queryOne() {
        List<User> query = jt.query("select * from user where id = ?",
                new BeanPropertyRowMapper<>(User.class), 3);
        System.out.println(query.isEmpty()?null:query.get(0));
    }

    @Test
    // 3.(多)行查询
    public void queryAll() {
        List<User> query = jt.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        for (User user : query) {
            System.out.println(user);
        }
    }

    @Test
    // 4.标量查询，可查询单个值或单个对象(单行)
    public void scalar() {
        Integer integer = jt.queryForObject("select count(*) from user", Integer.class);
        System.out.println("count(*) : " + integer);
    }
}
