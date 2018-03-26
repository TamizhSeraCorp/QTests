package com.seracorp.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seracorp.demo.model.LoginJson;

@FeignClient(name = "tvdb")
public interface TVDBClient {
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/login")
	ResponseEntity<String> login(LoginJson json);
}
