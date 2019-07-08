package org.devll.samples.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = Config.class)
@ContextConfiguration(classes = ScanConfig.class)
class InjectionTest {

    @Autowired
    private Book book;

    @Test
    void bookIsInjected() {
        assertNotNull(book);
    }
}
