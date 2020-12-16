package com.cms.secretsantabot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.Dao.EmployeeRepository;
import com.cms.secretsantabot.Modals.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}



	//wrtite methods to itneract db
}
