package com.cms.secretsantabot.Services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.repository.EmployeeRepository;
import com.cms.secretsantabot.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    //fetch all employees
    public List<Employee> getAllEmployees()  {
        return (List<Employee>) employeeRepository.findAll();
    }

    //Add employee
    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeesById(int id)
    {
        return (Employee) employeeRepository.getEmployeesById(id);
    }

    private Employee filterEmployees(Predicate<Employee> strategy) {
        return getAllEmployees().stream().filter(strategy).findFirst().orElse(null);
    }


}
