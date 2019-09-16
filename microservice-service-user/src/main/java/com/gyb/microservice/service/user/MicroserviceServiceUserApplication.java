package com.gyb.microservice.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class MicroserviceServiceUserApplication {

    @GetMapping("/hello")
    public String service(){
        return "hello eureka client!";
    }
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceServiceUserApplication.class, args);
    }

}
