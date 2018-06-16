package com.joelgtsantos.consumeremailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joelgtsantos.consumeremailservice.services.EmailService;

@SpringBootApplication
public class ConsumerEmailServiceApplication implements ApplicationRunner {
	
	@Autowired
	private EmailService emailService;

	private static Logger log = LoggerFactory.getLogger(ConsumerEmailServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerEmailServiceApplication.class, args);
	}
	
	@Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");
        
        //EmailService.send
        //"Sending Simple Email with JavaMailSender Example");
        //EmailService.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

        //emailService.sendSimpleMessage("joelgtsantos@gmail.com", "subject", "text");
    }
}
