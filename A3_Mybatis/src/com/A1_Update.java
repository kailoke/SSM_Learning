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
 * 一、Sql配置文件
 * > 1. mybatis配置信息:Properties,settings,typeAliases,environments(DataSource,Tx),Mappers...
 * > 2. sql mapper
 *      # namespace : mapper接口类
 *      > 其他查询标签
 *
 * 二、传统sqlSession执行
 * > sqlSession直接调用查询方法，传入 statement && parameters
 *  > statement – Unique identifier matching the statement to use。全类名SqlID映射
 *  > parameter – A parameter object to pass to the statement.
 *
 * 三、基于Mapper接口
 * > 1. 绑定 Mapper接口：指定 namespace 为接口全类名
 * > 2. sql语句 绑定 Mapper接口方法：#id
 * > 3. 获取Mybatis为Mapper生成的代理实现类对象
 *
 * 四、Mybatis执行流程
 * > 1.创建SqlSessionFactory < Builder.build(mybatis-config.xml + mapper.xml)
 * > 2.获取SqlSession < ↑openSession()
 * > 3.Executor：基本执行器 || 缓存执行器
 * > 4.MappedStatement:映射语句最终执行
 */
public class A1_Update {
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
