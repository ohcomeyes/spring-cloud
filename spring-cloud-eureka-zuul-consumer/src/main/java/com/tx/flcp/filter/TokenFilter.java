package com.tx.flcp.filter;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: spring-cloud
 * @description: token验证
 * @author: Mr.Tang
 * @create: 2018-06-21 10:08
 **/
public class TokenFilter extends ZuulFilter{
    protected final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType() {
        //pre:路由之前
        //routing:路由中
        //post:路由后
        //error:发生错误时
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() {
        this.logger.info("This is pre-type zuul filter.");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            requestContext.setSendZuulResponse(true); //对请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);
            return null;
        }else{
            requestContext.setSendZuulResponse(false); //不对其进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("token is empty");
            requestContext.set("isSuccess", false);
            return null;
        }
    }
}
