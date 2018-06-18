package com.tx.flcp;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<MethodClient> {
    @Override
    public MethodClient create(Throwable throwable) {
        return new MethodClient() {
            @Override
            public String consumer() {
                return "Ribbon + hystrix ,提供者服务挂了:/consumer";
            }

            @Override
            public String dc() {
                return "Ribbon + hystrix ,提供者服务挂了:/dc";
            }
        };
    }
}
