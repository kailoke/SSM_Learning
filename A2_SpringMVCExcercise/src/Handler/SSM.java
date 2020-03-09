package Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EmployeeService;

import java.util.Map;

@Controller
public class SSM {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/obtainAllEmps", method = RequestMethod.GET)
    public String mybatisSpring(Map<String, Object> map) {
        System.out.println("service invoke");
        map.put("emps", employeeService.getAllEmps());
        return "employeeList";
    }
}