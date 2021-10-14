package com.naturalprogrammer.spring5tutorial.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring5tutorial.mail.MailSender;

@RestController
public class MailController {
	
	@Autowired
	private MailSender mailSender;
	
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		mailSender.send("example@gmail.com", "A test mail", "Body of the test mail");
		
		return "Mail sent";
	}

}
