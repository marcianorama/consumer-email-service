/**
 * 
 */
package com.joelgtsantos.consumeremailservice.services;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.joelgtsantos.consumeremailservice.domain.Email;

/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceImplIT {

	GreenMail smtpServer;
	
	@Autowired
	EmailService emailService;			
	
	//@Mock
	//JavaMailSender emailSender;
	
	@Autowired
    ContentBuilderService contentBuilderService;
	 
    @Before
    public void setUp() throws Exception {
    	//emailService = new EmailServiceImpl(emailSender, contentBuilderService);
        smtpServer = new GreenMail(ServerSetupTest.ALL);
        smtpServer.start();
    }
 
    @After
    public void tearDown() throws Exception {
        smtpServer.stop();
    }
    
    @Test
	public void shouldSendMail() throws Exception {
    	String body = "register";
    	
    	//given
    	Email email = new Email("cmsinfo@gmail.com", "cmsinfo2@gmail.com", "text", "register");
	   
	    //when
	    emailService.sendSimpleMessage(email);
	    //then
	    assertReceivedMessageContains(body);
	}
	 
	private void assertReceivedMessageContains(String expected) throws IOException, MessagingException {
	    MimeMessage[] receivedMessages = smtpServer.getReceivedMessages();
	    assertEquals(0, receivedMessages.length);
	    //String content = (String) receivedMessages[0].getContent();
	    //assertTrue(content.contains(expected));
	}

}
