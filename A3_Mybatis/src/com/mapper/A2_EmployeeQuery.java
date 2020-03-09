package com.mapper;

import com.domain.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface A2_EmployeeQuery {
    // 查询多行数据返回对象集合
    List<Employee> getEmps();

    // 查询单行数据返回map
    Map<String, Object> getMap(Integer id);

    // 查询多行数据返回map：@Mapkey()指定封装对象属性作为key
    @MapKey("id")
    Map<Integer, Employee> getEmpsMap();
}
