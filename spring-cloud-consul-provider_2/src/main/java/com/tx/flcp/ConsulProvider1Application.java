package com.tx.flcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: spring-cloud
 * @description: 消费者
 * @author: Mr.Tang
 * @create: 2018-06-15 14:54
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProvider1Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProvider1Application.class,args);
    }
}
