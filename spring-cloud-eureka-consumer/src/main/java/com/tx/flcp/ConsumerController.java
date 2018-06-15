package com.tx.flcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud
 * @description: 调用服务提供者的 `home` 方法
 * @author: Mr.Tang
 * @create: 2018-06-15 13:20
 **/
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }

    @GetMapping(value = "/hello1")
    public String hello1() {
        return restTemplate.getForEntity("http://eureka-provider/dc", String.class).getBody();
    }
}
