package com.elgregos.logging;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
@Log
public class ServiceBeanTest {

	@Inject
	private Logger logger;

	public void test() {
		this.logger.info("This is a test");
	}

}
