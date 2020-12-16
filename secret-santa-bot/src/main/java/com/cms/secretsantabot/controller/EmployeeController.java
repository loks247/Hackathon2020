package com.cms.secretsantabot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cms.secretsantabot.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	private EmployeeRepository repository;

	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/employees")
	public String getAllIssues(Model model) {
		model.addAttribute("employees", repository.findAll());
		System.out.println("records::"+repository.findAll());
		return "list-employees";
	}
}
