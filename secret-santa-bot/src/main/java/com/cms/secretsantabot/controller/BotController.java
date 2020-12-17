package com.cms.secretsantabot.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.services.EmployeeService;
import com.cms.secretsantabot.services.SecretNameGeneratingService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/secretSanta", produces = MediaType.APPLICATION_JSON_VALUE)
public class BotController {

  @Autowired
	EmployeeService employeeService;

  @Autowired
	SecretNameGeneratingService nameGeneratingService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("inside getAllEmployees");
		return employeeService.getAllEmployees();
	}

	@GetMapping(value = "/employees/{empId}")
	public Employee findById(@PathVariable("empId") int id) {
		System.out.println("inside find by id:"+ id);
		return employeeService.getEmployeesById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/employees",method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("inside add record:"+ employee);
		return employeeService.addEmployee(employee);
	}



	@PutMapping(value = "/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable( "id" ) Long id, @RequestBody Employee resource) {
		//checkNotNull
		//employeeService.update(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		//checkNotNull
		//employeeService.deleteById(id);
	}

	@GetMapping(value = "/getAllMatchedEmployees")
	public List<Employee> getAllMatchedEmployees() {
		log.info("Generation logic : controller");
		return employeeService.getAllEmployees();
	}

}
