package com.cms.secretsantabot.services;

import java.util.List;

import com.cms.secretsantabot.model.Employee;

public interface EmailService {

	public void sendEmails(List<Employee> fromGiftTos);

}
