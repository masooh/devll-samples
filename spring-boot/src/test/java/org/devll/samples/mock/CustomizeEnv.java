package org.devll.samples.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

/* must be registered in spring.factories
    org.springframework.boot.env.EnvironmentPostProcessor=org.devll.samples.springboot.CustomizeEnv
 */
public class CustomizeEnv implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        environment.getPropertySources().addLast(
               new MockPropertySource().withProperty("freePort", SocketUtils.findAvailableTcpPort())
        );
    }
}
