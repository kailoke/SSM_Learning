package com;

import com.domain.Employee;
import com.mapper.A4_DynamicSQLMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

public class A4_DynamicSQL {
    private SqlSession session = null;
    @Before
    public void init() {
        try {
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("A3_ResultMap.xml"));
            session = build.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destroy() {
        if (session != null){
            session.close();
        }
    }

    @Test
    // 1. OGNL 标签:if + where
    public void dynamicWhere() {
        A4_DynamicSQLMapper mapper = session.getMapper(A4_DynamicSQLMapper.class);
        Employee condition = new Employee();
//        condition.setId(6);
        condition.setName("张三丰");
        condition.setEmail("zsf@mybatis.com");
//        condition.setGender((byte) 1);
        List<Employee> empsByCondition = mapper.getEmpsByCondition(condition);
        System.out.println(empsByCondition);
    }

    @Test
    // 2. OGNL 标签:trim
    public void dynamicTrim() {
        A4_DynamicSQLMapper mapper = session.getMapper(A4_DynamicSQLMapper.class);
        Employee condition = new Employee();
//        condition.setId(6);
        condition.setName("张三丰");
        condition.setEmail("zsf@mybatis.com");
//        condition.setGender((byte) 1);
        List<Employee> empsByCondition = mapper.getEmpsByConditionTrim(condition);
        System.out.println(empsByCondition);
    }

    @Test
    // 3. OGNL 标签:Set
    public void dynamicSet() {
        A4_DynamicSQLMapper mapper = session.getMapper(A4_DynamicSQLMapper.class);
        Employee condition = new Employee();
        condition.setId(6);
        condition.setName("张三丰");
//        condition.setName("张四丰");
        condition.setEmail("zsf@mybatis.com");
//        condition.setGender((byte) 1);
        mapper.updateBySet(condition);
        session.commit();
    }

    @Test
    // 4. OGNL 标签:choose
    public void dynamicChoose() {
        A4_DynamicSQLMapper mapper = session.getMapper(A4_DynamicSQLMapper.class);
        Employee condition = new Employee();
//        condition.setId(6);
//        condition.setName("张三丰");
        List<Employee> empsByConditionChoose = mapper.getEmpsByConditionChoose(condition);
        empsByConditionChoose.forEach(System.out::println);
    }

    @Test
    // 5. OGNL 标签：foreach
    public void dynamicForeach() {
        A4_DynamicSQLMapper mapper = session.getMapper(A4_DynamicSQLMapper.class);
        List<Integer> idList = new ArrayList<>(Arrays.asList(4,5,6));
        List<Employee> empsByIdList = mapper.getEmpsByIdList(idList);
        empsByIdList.forEach(System.out::println);
    }
}
