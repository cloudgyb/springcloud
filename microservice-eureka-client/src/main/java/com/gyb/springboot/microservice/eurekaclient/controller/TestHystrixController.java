package com.gyb.springboot.microservice.eurekaclient.controller;

import com.gyb.springboot.microservice.eurekaclient.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestHystrixController {
    private RestTemplate restTemplate;

    public TestHystrixController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public UserVO profileInfo(@PathVariable String id) {
        return restTemplate.getForObject("http://USER-SERVICE/user/"+id,UserVO.class);
    }

    public UserVO defaultFallback(String id){
        return UserVO.builder().id(id).build();
    }
}
