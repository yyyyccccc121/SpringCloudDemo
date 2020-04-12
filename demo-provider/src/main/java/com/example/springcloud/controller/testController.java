package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @RequestMapping(value = "/test1")
    public String test1(){
        return "success provider";
    }
}
