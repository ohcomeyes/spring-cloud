package com.tx.flcp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-provider
 * @description: 服务提供方，将自身服务注册到 Eureka 注册中心，从而使服务消费方能够找到

 * @author: Mr.Tang
 * @create: 2018-06-13 17:18
 **/

@EnableEurekaClient
@RestController
@SpringBootApplication
public class EurekaProviderApplication {

    @Value("${server.port}")
    String port;

    @GetMapping("/")
    public String home() {
        return "Hello home,port:"+port;
    }

    @GetMapping("/dc")
    public String home1() {
        return "hello home1 ,port:"+port;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class,args);
    }
}
