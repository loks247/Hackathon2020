package com.cms.secretsantabot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cms.secretsantabot.Modals.Employee;
import com.cms.secretsantabot.Services.EmployeeService;

@RestController
@RequestMapping(value = "/api/santa/application", produces = MediaType.APPLICATION_JSON_VALUE)
public class BotController {

@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(value = "/employees/{id}")
	public Employee findById(@PathVariable("id") String id) {
		return employeeService.getEmployeesById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Employee resource) {
		
		//create
	}

	@PutMapping(value = "/{id}")
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

}
