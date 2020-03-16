package com;

import com.domain.Employee;
import com.mapper.A2_EmployeeQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 一、自动映射 结果集(resultType)
 *  > 核心：指定`封装数据`的类型，而不是结果的类型
 *
 * 二、参数传递
 * > 1.单个参数
 *  > sql语句可任意指定key
 * > 2.POJO
 *  > 类属性名和sql参数名相同时可进行自动POJO封装
 * > 3.多个参数
 *  > 自动Map封装，key是：paramX + [index]
 * > 4.具名参数(namedSpace)
 *  > @param(value)，替换自动Map中key[index]
 * > 5.主动封装为Map
 *  > key是Map中的key，不进行自动封装
 * > 6.Array || Collection 也会被封装为Map
 *     array || list/set
 *
 * 三、Sql语句预编译
 *  > # ~= PreparedStatement
 *  > $ ~= Statement
 */
public class A2_Query {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("A2_EmployeeQuery.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    // 查询多行数据，返回list
    public void returnList() {
        SqlSession session = sqlSessionFactory.openSession();
        A2_EmployeeQuery mapper = session.getMapper(A2_EmployeeQuery.class);
        List<Employee> emps = mapper.getEmps();
        System.out.println(emps);
    }

    @Test
    // 查询单行数据，返回map
    public void testMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        A2_EmployeeQuery mapper = sqlSession.getMapper(A2_EmployeeQuery.class);
        Map<String, Object> map = mapper.getMap(6);
        System.out.println(map);
    }

    @Test
    // 查询多行数据返回Map，需要在方法上注明 @MapKey
    public void testEmpsMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        A2_EmployeeQuery mapper = sqlSession.getMapper(A2_EmployeeQuery.class);
        Map<Integer, Employee> empsMap = mapper.getEmpsMap();
        System.out.println(empsMap);
    }

}
