package com.tx.flcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    MethodClient methodClient;

    @GetMapping(value = "/")
    public String hello(){
        return methodClient.consumer();
    }

    @GetMapping(value = "/dc")
    public String hello1(){
        return methodClient.dc();
    }

}
