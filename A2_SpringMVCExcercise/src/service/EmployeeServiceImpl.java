package service;

import Dao.EmployeeMapper;
import domain.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeServiceImpl")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Resource(name = "employeeMapper")
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmps() {
        return employeeMapper.getAllEmps();
    }
}
