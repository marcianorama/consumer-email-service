/**
 * 
 */
package com.joelgtsantos.consumeremailservice.services;

import com.joelgtsantos.consumeremailservice.domain.Email;

/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
public interface EmailService {
	void sendSimpleMessage(Email email);
}
