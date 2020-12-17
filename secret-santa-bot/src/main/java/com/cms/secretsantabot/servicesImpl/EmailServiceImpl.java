package com.cms.secretsantabot.servicesImpl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.repository.EmployeeRepository;
import com.cms.secretsantabot.services.EmailService;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Autowired
	private Environment environment;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmails(List<Employee> fromGiftTos) {
		fromGiftTos.stream().forEach(emp1 -> {
			Employee employee = employeeRepository.getEmployeesById(emp1.getToEmpId());
			SimpleMailMessage simpleMailMessage = composeEmail("subject", "message", employee);
			log.info("Sending Email to={}", employee.getEmpName());
			mailSender.send(simpleMailMessage);
		});
	}

	public SimpleMailMessage composeEmail(String subject, String messageText, Employee employee) {

		final SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(subject);
		message.setText(messageText);
		message.setTo(employee.getEmailAddress());
		message.setFrom(environment.getProperty("customer.care.email"));
		return message;
	}
}

