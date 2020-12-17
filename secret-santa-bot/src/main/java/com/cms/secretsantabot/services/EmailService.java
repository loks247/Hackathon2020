package com.cms.secretsantabot.services;

import java.util.List;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.model.FromGiftTo;

public interface EmailService {

	public void sendEmails(List<FromGiftTo> fromGiftTos);

}
