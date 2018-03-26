package com.seracorp.demo.feign;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.seracorp.demo.model.LoginJson;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeignDemoClientTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPosts() {
    	LoginJson request = new LoginJson();
    	request.setApikey("4D0C09CAF0290409");
    	 
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/login", request, String.class);//("/login", String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(String.format("Actual status code: %d, reason: %s.",
                statusCode.value(), statusCode.getReasonPhrase()),
                statusCode.is2xxSuccessful(), equalTo(true));
    }

}
