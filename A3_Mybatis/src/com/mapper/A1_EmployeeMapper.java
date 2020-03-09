package com.mapper;

import com.domain.Employee;

public interface A1_EmployeeMapper {
    // 定义CRUD相关接口方法，但不需要实现

    Employee getEmployeeById(int id);

    int addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);
}
