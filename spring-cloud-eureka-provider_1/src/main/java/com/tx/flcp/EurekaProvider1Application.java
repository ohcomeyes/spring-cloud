package com.tx.flcp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud
 * @description: 服务提供_1
 * @author: Mr.Tang
 * @create: 2018-06-15 12:54
 **/
@RefreshScope
@RestController
@EnableEurekaClient
@SpringBootApplication
public class EurekaProvider1Application {
    @Value("${server.port}")
    String port;

    @Value("${version}")
    String version;

    @GetMapping("/")
    public String home() {
        return "Hello home,port:"+port+"--version:"+version;
    }

    @GetMapping("/dc")
    public String home1() {
        return "hello home1 ,port:"+port+"--version:"+version;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider1Application.class,args);
    }
}
