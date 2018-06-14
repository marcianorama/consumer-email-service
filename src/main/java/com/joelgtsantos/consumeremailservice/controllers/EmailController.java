/**
 * 
 */
package com.joelgtsantos.consumeremailservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.joelgtsantos.consumeremailservice.services.EmailService;


/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
public class EmailController {
	private EmailService emailService;
	
	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	/*public String sendEmail(to) {
		return emailService.sendSimpleMessage(to, subject, text);
	}*/
}
