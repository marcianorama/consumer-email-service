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
public interface ContentBuilderService {

	public String build(Email email);
}
