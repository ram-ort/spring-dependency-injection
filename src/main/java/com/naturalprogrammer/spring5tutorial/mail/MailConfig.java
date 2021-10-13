package com.naturalprogrammer.spring5tutorial.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailConfig {
	
	@Bean
	public DemoBean demoBean() {
		
		return new DemoBean();
	}
	
	@Bean
	@ConditionalOnProperty(name="spring.mail.host", havingValue = "foo", matchIfMissing = true)
//	@Profile("dev")
	public MailSender mockMailSenderBean() {
		
		demoBean();
		
		return new MockMailSender();
	}
	
	@Bean
	@ConditionalOnProperty("spring.mail.host")
//	@Profile("!dev")
	public MailSender smtpMailSenderBean(JavaMailSender javaMailSender) {
		
		return new SmtpMailSender(javaMailSender);
	}

}
