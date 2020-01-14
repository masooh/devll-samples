package org.devll.samples.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class InjectionManualTest {

    @Test
    void bookIsInContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(Config.class);
        applicationContext.refresh();

        Book book = (Book) applicationContext.getBean("book");

        assertNotNull(book);
    }
}
