package com.karankatnani.springrestapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringRestApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void statisticsShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/statistics",
				String.class)).contains("inputCount");
		System.out.println("statistics end point returning JSON");
	}

	@Test
	public void testJsonResponses() throws Exception{
		String[] testArray = {"{ \"medicationStrings\":[ \"186FASc73541_M_1058\" , \"18673cda541_S_0061 \"] }",};
		String[] testArray2 = {"{ \"medicationString\":[ \"186FASc73541_M_10\" , \"18673cda541_S_00 \"] }", };
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		for (String testString:testArray) {
			HttpEntity<String> request = new HttpEntity<String>(testString, headers);
			assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/input",request,String.class).getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
			System.out.println("statistics end point accepting valid json strings");
		}

		for (String testString:testArray2) {
			HttpEntity<String> request = new HttpEntity<String>(testString, headers);
			assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/input",request,String.class).getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
			System.out.println("statistics end point forbidding invalid json strings");
		}

	}
}