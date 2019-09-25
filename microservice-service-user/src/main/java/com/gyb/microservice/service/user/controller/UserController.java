package com.gyb.microservice.service.user.controller;

import com.gyb.microservice.service.user.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "defaultFallback")
    public UserVO getUserInfo(@PathVariable String id){
        return UserVO.builder().id(id).name("test").age(12).sex("男").build();
    }

    public UserVO defaultFallback(@PathVariable String id) {
        return UserVO.builder().id(id).build();
    }

}
