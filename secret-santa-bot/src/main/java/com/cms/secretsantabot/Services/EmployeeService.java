package com.cms.secretsantabot.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.Dao.EmployeeRepository;
import com.cms.secretsantabot.Modals.Employee;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<Employee> getAllEmployees()  {
        return (List<Employee>) employeeRepository.getAllEmployees();
    }
    
    
    public Employee getEmployeesById(String id) 
        {
            return (Employee) employeeRepository.getEmployeesById(id);
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
