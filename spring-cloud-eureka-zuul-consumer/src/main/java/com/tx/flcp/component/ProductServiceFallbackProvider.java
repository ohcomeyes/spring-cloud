package com.tx.flcp.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @program: spring-cloud
 * @description: zuul容错与回退
 * @author: Mr.Tang
 * @create: 2018-06-20 14:25
 **/
@Component
public class ProductServiceFallbackProvider implements FallbackProvider {
    protected final Logger logger = LoggerFactory.getLogger(ProductServiceFallbackProvider.class);
    @Override
    public String getRoute() {
        // 注意: 这里是route的名称，不是服务的名称，否则无法起到回退作用
        return "ribbon-consumer";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                logger.info("ribbon-consumer: 服务不可以");
                return new ByteArrayInputStream("该服务暂不可用，请稍后重试!".getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }
        };
    }
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            logger.info("Excption {}",reason);
        }
        return fallbackResponse();
    }
}
