package com.tx.flcp;

import com.tx.flcp.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud
 * @description: 服务消费者
 * @author: Mr.Tang
 * @create: 2018-06-15 13:14
 **/
@EnableZuulProxy
@SpringBootApplication
public class ZuulConsumerApplication {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulConsumerApplication.class, args);
    }
}
