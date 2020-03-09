package com;

import com.domain.Department;
import com.domain.Employee;
import com.mapper.A1_DepartmentMapper;
import com.mapper.A3_EmployeeResultMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义映射测试
 */
public class A3_ResultMap {
    private SqlSession session = null;
    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("A3_ResultMap.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession();
    }
    @After
    public void destroy() {
        if (session != null) session.close();
    }


    @Test
    // 1.resultMap 映射
    public void resultMap() {
        A3_EmployeeResultMap mapper = session.getMapper(A3_EmployeeResultMap.class);
        Employee employee = mapper.getEmployeeById(10);
        System.out.println(employee);
    }

    @Test
    // 2.级联访问 内联属性
    public void resultMapCascade() {
        A3_EmployeeResultMap mapper = session.getMapper(A3_EmployeeResultMap.class);
        Employee employeeDept = mapper.getEmployeeDept(3);
        System.out.println(employeeDept);
        System.out.println(employeeDept.getDepartment());
    }

    @Test
    // 3.1 association 内联对象自定义映射
    public void association() {
        A3_EmployeeResultMap mapper = session.getMapper(A3_EmployeeResultMap.class);
        Employee employeeDept = mapper.getEmployeeStep(9);
        System.out.println(employeeDept);
        System.out.println(employeeDept.getDepartment());
    }
    @Test
    // 3.2 association-select:sql子查询结果作为映射结果赋值给property
    public void associationStep() {
        A3_EmployeeResultMap mapper = session.getMapper(A3_EmployeeResultMap.class);
        Employee employeeDept = mapper.getEmployeeStep(9);
        System.out.println(employeeDept.getName());
        // lazyLoad，访问属性时进行查询 on demand
//        System.out.println(employeeDept.getDepartment());
    }

    @Test
    // 4.1 collection集合类型自定映射
    public void collection() {
        A1_DepartmentMapper mapper = session.getMapper(A1_DepartmentMapper.class);
        Department departmentAndEmps = mapper.getDepartmentAndEmps(1);
        System.out.println(departmentAndEmps);
    }

    @Test
    // 4.2 collection 分步查询
    public void collectionStep() {
        A1_DepartmentMapper mapper = session.getMapper(A1_DepartmentMapper.class);
        Department departmentAndEmps = mapper.getDepartmentAndEmpsStep(1);
        System.out.println(departmentAndEmps.getId());
        System.out.println(departmentAndEmps.getName());
        // 延迟加载
        System.out.println(departmentAndEmps.getEmps());
    }
}
