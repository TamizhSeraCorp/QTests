package com.seracorp.demo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class FeignDemoClient {
    public static void main(String[] args) {
        SpringApplication.run(FeignDemoClient.class, args);
    }

    @RestController
    static class DemoController {
        @Autowired
        private RedditClient redditClient;

        @GetMapping("/posts")
        public String posts() {
            return redditClient.posts();
        }
    }
}
