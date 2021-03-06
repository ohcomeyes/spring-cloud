package com.tx.flcp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "defaultStores")
    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "defaultStores1")
    @GetMapping(value = "/hello1")
    public String hello1() {
        return restTemplate.getForEntity("http://eureka-provider/dc", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "defaultStores1")
    @GetMapping(value = "/product")
    public String product() {
        return restTemplate.getForEntity("http://eureka-provider/product", String.class).getBody();
    }

    public String defaultStores(){
        return "/hello提供者服务挂了:";
    }

    public String defaultStores1(){
        return "/hello1提供者服务挂了:";
    }

    public String defaultStores2(){
        return "/product提供者服务挂了:";
    }
}
