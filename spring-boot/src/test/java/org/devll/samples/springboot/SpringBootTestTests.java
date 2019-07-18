package org.devll.samples.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.boot.test.context.AnnotatedClassFinder;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.mock.env.MockPropertySource;

import java.util.List;

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

	@Test
	void springFactoriesLoader() {
		// typisierte Liste kommt zurück -> müssen alle assigned werden können
		List<SpringFactoryClass> factories = SpringFactoriesLoader.loadFactories(SpringFactoryClass.class, null);

		System.out.println(factories);

		// geht wohl nicht für Annotations
        List<EnableAutoConfiguration> enableAutoConfigurations = SpringFactoriesLoader.loadFactories(EnableAutoConfiguration.class, null);
        System.out.println(enableAutoConfigurations);
    }

	@Test
	void classPathBeanDefinitionScanner() {
		GenericApplicationContext context = new GenericApplicationContext();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		System.out.println(String.join("\n", context.getBeanDefinitionNames()));
		int registeredBeans = scanner.scan("org.devll.samples.springboot");
		System.out.println(registeredBeans);
		System.out.println(String.join("\n", context.getBeanDefinitionNames()));

		/*
		findet @Configuration und @Service -> Mischung auf Config und Beans
		Bean in Config ist nicht gefunden, kommt wohl später
		 */
	}

	static class SpringFactoryClass {

	}

	static class SpringFactoryObject extends SpringFactoryClass {

	}
}
