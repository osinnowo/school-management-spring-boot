package com.appcoy.student.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@SpringBootTest
@ExtendWith({SpringExtension.class})
class StudentApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void healthCheck() {
		webTestClient
				.get()
				.uri("/actuator")
				.exchange()
				.expectStatus().isOk();
	}
}
