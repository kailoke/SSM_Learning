package com.mapper;

import com.domain.Employee;

import java.util.List;

/**
 * 自定义映射 resultMap
 */
public interface A3_EmployeeResultMap {
    // 查询员工
    Employee getEmployeeById(Integer id);

    // 查询员工部门
    Employee getEmployeeDept(Integer id);

    // association分步查员工部门
    Employee getEmployeeStep(Integer id);

    // collection分步查部门员工
    List<Employee> getEmpsByDid(Integer id);
}
