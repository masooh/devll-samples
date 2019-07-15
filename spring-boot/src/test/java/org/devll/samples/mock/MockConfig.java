package org.devll.samples.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MockConfig {

    @Autowired
    Environment environment;

    @Bean
    public Integer freePort() {
        return Integer.parseInt(environment.getProperty("freePort"));
    }
}
