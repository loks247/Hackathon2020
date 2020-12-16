package com.cms.secretsantabot.Modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "employee")
@AllArgsConstructor
@Data
//@Entity
public class Employee {
	//@Id
	private String id;
	private String empId;
	private String empName;
	private String emailAddress;
	private String giftIdea;
	
	public Employee() {
	}

	public Employee(String empId, String empName, String emailAddress) {
		this.empId = empId;
		this.emailAddress = empName;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee[id=%s, e_id='%s', name='%s', emailaddress='%s']",
				empId, empId, empName, emailAddress);
	}
	
}
