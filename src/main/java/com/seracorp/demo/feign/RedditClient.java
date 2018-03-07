package com.seracorp.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "reddit")
public interface RedditClient {
    @RequestMapping(method = RequestMethod.GET, value = "/r/java/top.json?count=1",
            headers = {HttpHeaders.USER_AGENT + "=Mozilla/5.0", HttpHeaders.ACCEPT + "=" + MediaType.APPLICATION_JSON_VALUE})
    public String posts();
}