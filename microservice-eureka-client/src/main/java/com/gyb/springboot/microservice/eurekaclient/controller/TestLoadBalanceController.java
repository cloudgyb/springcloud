package com.gyb.springboot.microservice.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class TestLoadBalanceController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/testLoadBalance")
    public String testLoadBalance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");
        log.info(serviceInstance.getHost()+":"+serviceInstance.getPort());
        return restTemplate.getForObject("http://USER-SERVICE/hello",String.class);
    }
}
