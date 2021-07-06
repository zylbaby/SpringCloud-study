package com.example.zuulexample.config;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ZuulConfig {

    @Bean
    public ZuulFilter sentinelZuulPreFilter() {
        // We can provider the filter order here.
        return new SentinelZuulPreFilter(10000);
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter(1000);
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter(-1);
    }

    @PostConstruct
    public void doInit() {
        // 注册 FallbackProvider
        ZuulBlockFallbackManager.registerProvider(new MyBlockFallbackProvider());
       // initGatewayRules();
    }
}
