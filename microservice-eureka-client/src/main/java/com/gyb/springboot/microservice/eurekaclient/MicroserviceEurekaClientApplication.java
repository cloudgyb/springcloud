package com.gyb.springboot.microservice.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroserviceEurekaClientApplication {

    @GetMapping("/hello")
    public String service(){
        return "hello eureka client!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaClientApplication.class, args);
    }

}
