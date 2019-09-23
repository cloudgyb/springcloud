package com.gyb.microservice.service.user.controller;

import com.gyb.microservice.service.user.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public UserVO getUserInfo(@PathVariable String id){
        return UserVO.builder().id(id).name("test").age(12).sex("男").build();
    }



}
