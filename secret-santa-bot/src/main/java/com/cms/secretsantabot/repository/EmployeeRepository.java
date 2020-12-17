package com.cms.secretsantabot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cms.secretsantabot.model.Employee;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    @Override
    public List<Employee> findAll();

    public Employee getEmployeesById(int id);

    @Override
    public Employee save(Employee employee);

}
