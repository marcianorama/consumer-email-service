/**
 * 
 */
package com.joelgtsantos.consumeremailservice.services;

/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);
}
