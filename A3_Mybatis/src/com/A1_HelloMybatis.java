package com;

import com.domain.Employee;
import com.mapper.A1_EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 一、SqlMapConfig.xml 全局配置文件
 * > 初始化mybatis:DataSource,Tx,Mapper
 *
 * 二、mapper.xml sql映射文件
 * > <mapper namespace><select id,resultType>sql
 *
 * 三、基于Mapper接口
 * > 1.绑定 Mapper接口 && sql映射文件
 * > 指定 namespace为接口全类名
 * > 2.绑定 Mapper接口方法 && sql语句
 * > select id值=方法名
 * > 3.获取Mybatis为Mapper生成的代理实现类对象
 */

public class A1_HelloMybatis {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "A1_mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    // 1.传统sqlSession
    public void sqlSession() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // statement – Unique identifier matching the statement to use.
            // parameter – A parameter object to pass to the statement.
            Employee employee = session.selectOne("com.mapper.A1_EmployeeMapper.selectEmployee", 6);
            System.out.println(employee);
        }
    }

    @Test
    // 2.Mapper接口(Dao接口)
    public void mapperSelect() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            A1_EmployeeMapper mapper = sqlSession.getMapper(A1_EmployeeMapper.class);
            // 方法名具有明确意义
            // 方法参数有明确的类型约束
            // 接口的多态性，提供规范，兼容实现类
            Employee employeeById = mapper.getEmployeeById(5);
            System.out.println(employeeById);
        }
    }

    @Test
    // 3.使用mapper执行<insert>
    public void mapperInsert() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            A1_EmployeeMapper mapper = session.getMapper(A1_EmployeeMapper.class);
            Employee e = new Employee("孟德", "cc@md.com", (byte) 1);
            int insert = mapper.addEmployee(e);
            System.out.println("return :" + insert);
            System.out.println("keyProperty:" + e.getId());
//            session.commit();
        }
    }

    @Test
    // 4.mapper execute <update>
    public void mapperUpdate() {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            A1_EmployeeMapper mapper = session.getMapper(A1_EmployeeMapper.class);
            mapper.updateEmployee(new Employee(9,"夏侯惇","xhd@sg.com", (byte) 1));
        }
    }

    @Test
    // 5. mapper returnType boolean
    public void mapperDelete() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            A1_EmployeeMapper mapper = session.getMapper(A1_EmployeeMapper.class);
            boolean b = mapper.deleteEmployee(15);
            System.out.println("boolean:" + b);
        }
    }
}
