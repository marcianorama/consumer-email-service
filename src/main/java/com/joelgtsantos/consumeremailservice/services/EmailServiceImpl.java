/**
 * 
 */
package com.joelgtsantos.consumeremailservice.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.joelgtsantos.consumeremailservice.domain.Email;

/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
@Service
public class EmailServiceImpl implements EmailService {
  
	private Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	
    private final JavaMailSender emailSender;
    private final ContentBuilderService contentBuilderService;
    
    /*
     * Constructor
    */
    public EmailServiceImpl(JavaMailSender emailSender, ContentBuilderService contentBuilderService) {
    	this.emailSender = emailSender;
    	this.contentBuilderService = contentBuilderService;
    }
 

	/* Receive an email bean which will be used to generate an email
	 * @see com.joelgtsantos.consumeremailservice.services.EmailService#sendSimpleMessage(com.joelgtsantos.consumeremailservice.domain.Email)
	 */
    public void sendSimpleMessage(Email email) {
    	try {
    		MimeMessagePreparator messagePreparator = mimeMessage -> {
		        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
		        messageHelper.setFrom(email.getFrom());
		        messageHelper.setTo(email.getTo());
		        messageHelper.setSubject(email.getSubject());
		        String content = contentBuilderService.build(email);
		        messageHelper.setText(content, true);
		    };
	        emailSender.send(messagePreparator);
	        
    	} catch (MessagingException e) {
    		log.error("Error occurred sending email", e);
        }
    }
}
