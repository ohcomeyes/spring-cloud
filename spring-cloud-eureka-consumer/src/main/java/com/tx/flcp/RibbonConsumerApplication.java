package com.tx.flcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud
 * @description: 服务消费者
 * @author: Mr.Tang
 * @create: 2018-06-15 13:14
 **/
@EnableHystrix
//@EnableDiscoveryClient //使用其他的注册中心后，都可以使用@EnableDiscoveryClient注解
@EnableEurekaClient //使用@EnableEurekaClient的情景，就是在服务采用eureka作为注册中心的时候，使用场景较为单一。
@SpringBootApplication
public class RibbonConsumerApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }
}
