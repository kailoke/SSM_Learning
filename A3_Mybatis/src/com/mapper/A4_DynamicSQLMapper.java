package com.mapper;

import com.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface A4_DynamicSQLMapper {
    // 1.不确定数据数量，使用对象传输数据
    List<Employee> getEmpsByCondition(Employee condition);

    // 2.<trim>
    List<Employee> getEmpsByConditionTrim(Employee condition);

    // 3.<set> 修改sql数据
    void updateBySet(Employee condition);

    // 4.<choose>，当有条件成功则立即执行，或者指定 otherwise
    List<Employee> getEmpsByConditionChoose(Employee condition);

    // 5.<foreach>
    List<Employee> getEmpsByIdList(@Param("idList") List<Integer> idList);
}
