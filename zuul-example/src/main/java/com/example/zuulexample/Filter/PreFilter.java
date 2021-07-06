package com.example.zuulexample.Filter;

import com.example.zuulexample.config.ConfigModule;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@EnableConfigurationProperties(ConfigModule.class)
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    private final RateLimiter rateLimiter=RateLimiter.create(10);

    @Autowired
    private ConfigModule configModule;

//    @Value("${exits}")
//    private List<String> excludeUrls;
   // private String excludeUrls;

    private AtomicInteger atomicInteger=new AtomicInteger();
    @Override
    public int filterOrder() {
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        List<String> excludeUrls = configModule.getUrls();
//        if(excludeUrls!=null&&excludeUrls.size()>0){
//            for(String url:excludeUrls){
//                if(requestURI.contains(url)){
//                    System.out.println(requestURI+"不走拦截");
//                    return false;
//                }
//            }
//        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        if(!rateLimiter.tryAcquire()){
            RequestContext currentContext = RequestContext.getCurrentContext();
            HttpServletRequest request = currentContext.getRequest();
            String requestURI = request.getRequestURI();
            System.out.println("请求的路径:"+requestURI);
            currentContext.setSendZuulResponse(false);
            int i = atomicInteger.incrementAndGet();
            currentContext.setResponseStatusCode(400);
            currentContext.setResponseBody("当前服务器繁忙，请稍后重试");
            currentContext.addZuulResponseHeader("Content-Type", "text/plain;charset=UTF-8");
            System.out.println("sorry , this time is have too many request ,please wait a woment,"+i);
        }
        return null;
    }
}
