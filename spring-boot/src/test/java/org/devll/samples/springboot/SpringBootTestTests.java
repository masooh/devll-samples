package org.devll.samples.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.AnnotatedClassFinder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

class SpringBootTestTests {

	@Test
	void annotatedClassFinderClass() {
		AnnotatedClassFinder annotatedClassFinder = new AnnotatedClassFinder(SpringBootConfiguration.class);

		Class<?> found = annotatedClassFinder.findFromClass(SpringBootTestTests.class);

		System.out.println(found);
	}

	@Test
	void annotatedClassFinderPackage() {
		AnnotatedClassFinder annotatedClassFinder = new AnnotatedClassFinder(SpringBootConfiguration.class);

		Class<?> found = annotatedClassFinder.findFromPackage("org.devll.samples.springboot");

		System.out.println(found);
	}

	@Test
	void configurationClassParser() {
//		new ConfigurationClassPostProcessor()
	}
}
