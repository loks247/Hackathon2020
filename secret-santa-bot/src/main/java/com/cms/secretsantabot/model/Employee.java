package com.cms.secretsantabot.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Getter
@Setter
public class Employee {
	@Id
	private int id;
	private String empName;
	private String emailAddress;
	private Map<String, String> wishList;

	public Employee() {
	}

	public Employee(int id, String empName, String emailAddress, Map<String, String> wishList) {
		this.id = id;
		this.emailAddress = empName;
		this.emailAddress = emailAddress;
		this.wishList = wishList;
	}

	@Override
	public String toString() {
		return String.format("Employee[empId='%s', empName='%s', emailAddress='%s', wishList='%s']", id, empName, emailAddress, wishList.toString());
	}

}
