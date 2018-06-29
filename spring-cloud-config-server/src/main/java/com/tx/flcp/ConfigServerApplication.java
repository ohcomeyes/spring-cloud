package com.tx.flcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: spring-cloud
 * @description: 启动服务配置
 * @author: Mr.Tang
 * @create: 2018-06-22 11:01
 **/
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
