package com.tx.flcp;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<MethodClient> {
    @Override
    public MethodClient create(Throwable throwable) {
        return new MethodClient() {
            @Override
            public String hello() {
                return "feign ,提供者服务挂了:/hello";
            }

            @Override
            public String hello1() {
                return "feign ,提供者服务挂了:/hello1";
            }

            @Override
            public String product() {
                return "feign ,提供者服务挂了:/product";
            }
        };
    }
}
