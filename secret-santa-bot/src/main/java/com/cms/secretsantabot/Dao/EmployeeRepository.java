package com.cms.secretsantabot.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cms.secretsantabot.model.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public List<Employee> getAllEmployees();

    public Employee getEmployeesById(String id);

    public Employee addEmployees(Employee employee);

}
