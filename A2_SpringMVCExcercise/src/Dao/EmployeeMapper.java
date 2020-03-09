package Dao;

import domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    // 定义CRUD相关接口方法，但不需要实现
    List<Employee> getAllEmps();
}
