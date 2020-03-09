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
 * 查询数据的不同返回形式
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
