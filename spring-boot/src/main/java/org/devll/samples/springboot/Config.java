package org.devll.samples.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    Book book() {
        return new Book();
    }
}
