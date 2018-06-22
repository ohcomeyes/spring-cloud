package com.tx.flcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    MethodClient methodClient;

    @GetMapping(value = "/feign/hello")
    public String hello(){
        return methodClient.hello();
    }

    @GetMapping(value = "/feign/hello1")
    public String hello1(){
        return methodClient.hello1();
    }

}
