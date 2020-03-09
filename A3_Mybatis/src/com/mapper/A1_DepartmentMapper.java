package com.mapper;

import com.domain.Department;

public interface A1_DepartmentMapper {
    Department getDepartmentById(Integer id);

    // 查询部门，及其部门所有员工
    Department getDepartmentAndEmps(Integer id);

    Department getDepartmentAndEmpsStep(Integer id);
}
