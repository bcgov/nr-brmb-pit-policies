package ca.bc.gov.mal.cirras.policies.service.api.v1.util;

import java.util.Properties;

import jakarta.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EmailUtils {
	
	private EmailUtils() {
		// private constructor
	}
	
	private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

	public static final String EMAIL_HOST_NAME_PROPERTY = "email.host.name";
	public static final String EMAIL_PORT_PROPERTY = "email.port";
	public static final String EMAIL_FROM_ADDRESS_PROPERTY = "email.from.address";
	
	private static Session mailSession;

	public static Session getEmailSession(Properties applicationProperties) {
		logger.debug("<getEmailSession");
		
		if(mailSession == null) {
			String emailHostName = applicationProperties.getProperty(EMAIL_HOST_NAME_PROPERTY);
			if(emailHostName==null||emailHostName.trim().length()==0) {
				
				throw new RuntimeException("Missing property '"+EMAIL_HOST_NAME_PROPERTY+"'");
			}
			
			String emailPort = applicationProperties.getProperty(EMAIL_PORT_PROPERTY);
			if(emailPort==null||emailPort.trim().length()==0) {
				
				throw new RuntimeException("Missing property '"+EMAIL_PORT_PROPERTY+"'");
			}
			
			String emailFromAddress = applicationProperties.getProperty(EMAIL_FROM_ADDRESS_PROPERTY);
			if(emailFromAddress==null||emailFromAddress.trim().length()==0) {
				
				throw new RuntimeException("Missing property '"+EMAIL_FROM_ADDRESS_PROPERTY+"'");
			}
			
			Properties mailProperties = new Properties();
			mailProperties.setProperty("mail.smtp.host", emailHostName);
			mailProperties.setProperty("mail.smtp.port", emailPort);
			mailProperties.setProperty("mail.from.address", emailFromAddress);
			
			mailSession = Session.getDefaultInstance(mailProperties);
		}
		
		logger.debug(">getEmailSession");
		return mailSession;
	}

}
