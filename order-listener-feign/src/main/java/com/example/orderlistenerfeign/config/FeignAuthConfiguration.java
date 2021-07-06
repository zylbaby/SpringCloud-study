package com.example.orderlistenerfeign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

@ExcludeAnnon
public class FeignAuthConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("root", "root");
    }

}
