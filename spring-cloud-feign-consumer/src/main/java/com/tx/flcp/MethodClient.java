package com.tx.flcp;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provider",fallbackFactory = HystrixClientFallbackFactory.class)
public interface MethodClient {

    @GetMapping("/")
    String hello();

    @GetMapping("/dc")
    String hello1();

    @GetMapping("/product")
    String product();
}
