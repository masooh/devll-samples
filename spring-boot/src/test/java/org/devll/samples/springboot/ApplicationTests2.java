package org.devll.samples.springboot;

import org.devll.samples.mock.MockServer;
import org.devll.samples.mock.MockServerTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@MockServerTest
//@TestPropertySource("random=${random.int}") geht in properties, aber nicht hier
//@TestPropertySource("freePortDependant=${freePort}") geht auch nicht
public class ApplicationTests2 {

	@Autowired
	Environment environment;

//	@Autowired
//	Integer freePort;

	MockServer mockServer;

	@Test
	public void contextLoads() {
		System.out.println(environment.getProperty("random"));
		System.out.println(environment.getProperty("freePort"));
//		System.out.println(freePort);

		System.out.println(mockServer);
		System.out.println(mockServer.getPort());
	}
}
