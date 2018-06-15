package com.tx.flcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud
 * @description: 服务消费
 * @author: Mr.Tang
 * @create: 2018-06-15 14:06
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConsumerApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplication.class,args);
    }
}
