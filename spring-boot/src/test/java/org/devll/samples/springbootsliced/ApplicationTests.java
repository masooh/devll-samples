package org.devll.samples.springbootsliced;

import org.devll.samples.springboot.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
 */
@SpringBootTest(classes = Application.class)
//@ContextConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		// 125 Beans, 3 von mir (ohne Spring Web)
		System.out.println(applicationContext.getBeanDefinitionCount());
		System.out.println(String.join("\n", applicationContext.getBeanDefinitionNames()));
	}
}
