/**
 *
 */
package com.elgregos.logging;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * @author Grégory
 *
 */
@Interceptor
@Log
public class LoggingInterceptor {

	@Inject
	private Logger logger;

	@AroundConstruct
	private void init(final InvocationContext invocationContext) throws Exception {
		final String constructorName = invocationContext.getConstructor().getName();
		this.logger.info("Entering constructor : " + constructorName);
		try {
			invocationContext.proceed();
		} finally {
			this.logger.info("Exiting constructor : " + constructorName);
		}
	}

	@AroundInvoke
	private Object logMethod(final InvocationContext invocationContext) throws Exception {
		final String methodName = invocationContext.getMethod().getName();
		this.logger.info("Entering constructor : " + methodName);
		try {
			return invocationContext.proceed();
		} finally {
			this.logger.info("Exiting constructor : " + methodName);
		}

	}

}
