package org.devll.samples.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    Book book() {
        return new Book();
    }
}
