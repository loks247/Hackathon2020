package com.cms.secretsantabot.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cms.secretsantabot.Modals.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
