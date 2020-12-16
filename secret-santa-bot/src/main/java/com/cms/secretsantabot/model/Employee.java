//package com.cms.secretsantabot.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "employees")
//@Getter
//@Setter
//public class Employee {
//
//	@Id
//	public String id;
//
//	public String e_id;
//	public String name;
//	public String emailAddress;
//
//	public Employee() {}
//
//	public Employee(String e_id, String name, String emailAddress) {
//		this.e_id = e_id;
//		this.name = name;
//		this.emailAddress = emailAddress;
//	}
//
//	@Override
//	public String toString() {
//		return String.format(
//			"Employee[id=%s, e_id='%s', name='%s', emailaddress='%s']",
//			id, e_id, name, emailAddress);
//	}
//
//}
//
