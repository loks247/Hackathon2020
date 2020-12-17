package com.cms.secretsantabot.servicesImpl;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.Dao.EmployeeRepository;
import com.cms.secretsantabot.model.Employee;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<Employee> getAllEmployees()  {
        return employeeRepository.getAllEmployees();
    }
    
    
    public Employee getEmployeesById(String id) 
        {
            return employeeRepository.getEmployeesById(id);
        }

    private Employee filterEmployees(Predicate<Employee> strategy) {
        return getAllEmployees().stream().filter(strategy).findFirst().orElse(null);
    }

    public Employee addEmployees(Employee employee)
    {
        employee.setId("123");
        return employee;
    }
    //wrtite methods to itneract db
}
