package org.devll.samples.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.boot.test.context.AnnotatedClassFinder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;

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

	@Test
	void propertySource() {
		System.out.println(new RandomValuePropertySource().getProperty("random.int"));
	}

	@Test
	void propertySourcesPropertyResolver() {
		MutablePropertySources propertySources = new MutablePropertySources();
		propertySources.addLast(
				new MockPropertySource()
						.withProperty("some", "value")
						.withProperty("random.int", "noInt")
		);

		propertySources.addLast(
				new RandomValuePropertySource()
		);

		PropertySourcesPropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

		System.out.println(propertyResolver.getProperty("some"));
		System.out.println(propertyResolver.getProperty("random.int")); // noInt, due to order of propertySources
		System.out.println(propertyResolver.getProperty("random.value"));
		System.out.println(propertyResolver.getProperty("any"));
	}
}
