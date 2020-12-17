package com.cms.secretsantabot.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@AllArgsConstructor
@Getter
@Setter
public class Employee {
	@Id
	private String id;
	private int empId;
	private String empName;
	private String emailAddress;
	private List<String> wishList;

	public Employee() {
	}

	public Employee(int empId, String empName, String emailAddress, List<String> wishList) {
		this.empId = empId;
		this.emailAddress = empName;
		this.emailAddress = emailAddress;
		this.wishList = wishList;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee[id=%s, empId='%s', empName='%s', emailAddress='%s']",
				id, empId, empName, emailAddress);
	}

}
