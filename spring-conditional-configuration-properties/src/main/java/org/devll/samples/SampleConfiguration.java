package org.devll.samples;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SampleProperties.class)
@ConditionalOnProperty(name = "sample.enabled", havingValue = "true")
/*
    if SampleProperties is under basePackage it is scanned by ConfigurationPropertiesScanRegistrar
    in that case it will be found and created and validated by ConfigurationPropertiesBindingPostProcessor
    even if sample.enabled=false

    --> EnableConfigurationProperties has only an effect if Properties file is *not* under basePackage
 */
public class SampleConfiguration {

    @Bean
    public String minIntBean(SampleProperties properties) {
        return properties.getMinInt().toString();
    }
}
