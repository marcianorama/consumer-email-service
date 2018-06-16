/**
 * 
 */
package com.joelgtsantos.consumeremailservice.services;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.joelgtsantos.consumeremailservice.domain.Email;

/**
 * @author Joel Santos
 *
 * consumer-email-service
 * 2018
 */
@Service
public class ContentBuilderServiceImpl implements ContentBuilderService {

	private final TemplateEngine templateEngine;
	

	/* 
	 * TemplateEngine injection 
	 */
    public ContentBuilderServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }
	
	/* Has in charge processing the Thymeleaf Template 
	 * by creating a new context and adding as a variable a email bean
	 * @see com.joelgtsantos.consumeremailservice.services.ContentBuilderService#build(com.joelgtsantos.consumeremailservice.domain.Email)
	 */
	@Override
	public String build(Email email) {
		Context context = new Context();
        context.setVariable("email", email);
        return templateEngine.process("mailTemplate", context);
	}

}
