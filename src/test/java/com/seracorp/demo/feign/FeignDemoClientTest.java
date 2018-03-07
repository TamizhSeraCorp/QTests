package com.seracorp.demo.feign;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class FeignDemoClientTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPosts() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/posts", String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(String.format("Actual status code: %d, reason: %s.",
                statusCode.value(), statusCode.getReasonPhrase()),
                statusCode.is2xxSuccessful(), equalTo(true));
    }

}
