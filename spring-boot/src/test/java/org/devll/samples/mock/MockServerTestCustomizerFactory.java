package org.devll.samples.mock;

import java.util.List;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.ContextConfigurationAttributes;
import org.springframework.test.context.ContextCustomizer;
import org.springframework.test.context.ContextCustomizerFactory;

public class MockServerTestCustomizerFactory implements ContextCustomizerFactory {
    @Override
    public ContextCustomizer createContextCustomizer(Class<?> testClass, List<ContextConfigurationAttributes> configAttributes) {
        if (AnnotatedElementUtils.findMergedAnnotation(testClass, MockServerTest.class) != null) {
            return new MockServerCustomizer();
        }
        return null;
    }
}
