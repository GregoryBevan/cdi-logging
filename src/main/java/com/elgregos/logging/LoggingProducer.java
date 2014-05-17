package com.elgregos.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer for logger injection
 *
 * @author Grégory
 */
public class LoggingProducer {

	@Produces
	private Logger getLogger(final InjectionPoint injectionPoint) {
		final String name = injectionPoint.getMember().getDeclaringClass().getName();
		return LoggerFactory.getLogger(name);
	}

}
