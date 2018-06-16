/**
 * 
 */
package com.joelgtsantos.consumeremailservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import com.joelgtsantos.consumeremailservice.domain.Email;
import com.joelgtsantos.consumeremailservice.services.EmailService;


/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
@Controller
public class EmailController {

	private Logger logger = LoggerFactory.getLogger(EmailController.class);

	@Autowired
	private EmailService emailService;

	/* (non-Javadoc)
	 * @see com.joelgtsantos.consumeremailservice.controllers.EmailController#receiveMessage(com.joelgtsantos.consumeremailservice.domain.Email)
	 */
	@RabbitListener(queues = "orderServiceQueue")
	public void receiveMessage(@Payload Email email) {
		logger.info("Received message '{}'", email.getFrom());
		this.emailService.sendSimpleMessage(email);	 
	}
}
