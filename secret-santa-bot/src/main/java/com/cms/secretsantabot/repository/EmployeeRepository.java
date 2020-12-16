package com.cms.secretsantabot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cms.secretsantabot.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	public Employee findByName(String firstName);
}
