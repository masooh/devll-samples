package org.devll.samples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

@SpringBootTest
@TestPropertySource(properties = {
		"dummy=blub",
		"sample.enabled=true",
		"sample.minInt=1"
})
class SpringConditionalConfigurationPropertiesApplicationTests {

	@Autowired(required = false)
	String minIntBean;

	@Test
	void contextLoads() {
		Assertions.assertEquals("1", minIntBean);
	}

}
