package org.devll.samples.mock;

import java.lang.reflect.Field;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class MockServerTestExecutionListener extends AbstractTestExecutionListener {

    MockServer mockServer;

    public MockServerTestExecutionListener() {
        System.out.println("Creating");
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        Environment environment = testContext.getApplicationContext().getEnvironment();
        int freePort = Integer.parseInt(environment.getProperty("freePort"));

        if (AnnotatedElementUtils.findMergedAnnotation(testContext.getTestClass(), MockServerTest.class) != null) {

            for (Field field : testContext.getTestClass().getDeclaredFields()) {
                if (field.getType().equals(MockServer.class)) {
                    mockServer = new MockServer(freePort);
                    field.setAccessible(true);
                    field.set(testContext.getTestInstance(), mockServer);
                }
            }
        }
    }

}
