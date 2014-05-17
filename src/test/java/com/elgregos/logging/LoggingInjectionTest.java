package com.elgregos.logging;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.elgregos.test.arquillian.EarDeployment;

@RunWith(Arquillian.class)
public class LoggingInjectionTest {

	@Deployment
	public static Archive<?> createDeploymentPackage() {
		return new EarDeployment("crud.ear") {
			{
				this.ejbModule.addClasses(LoggingProducer.class, Log.class, LoggingInterceptor.class, ServiceBeanTest.class).addAsManifestResource(
						"beans.xml", "beans.xml");
			}
		}.create();
	}

	@Inject
	ServiceBeanTest serviceBean;

	@Test
	public void test() {
		try {
			this.serviceBean.test();
		} catch (final Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
