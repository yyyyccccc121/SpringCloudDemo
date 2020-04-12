package com.example.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.CodeSource;
import java.security.ProtectionDomain;

@RestController
public class testController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "test1")
    //@HystrixCommand(fallbackMethod = "error",ignoreExceptions = RuntimeException.class,commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String test1() {
        //int a = 1/0;
        String ss = restTemplate.getForEntity("http://demo-provider/test1",String.class).getBody();
        return ss;
    }

    public String error(Throwable throwable){
        System.out.println("异常："+throwable.getMessage());
        return "error";
    }
}
