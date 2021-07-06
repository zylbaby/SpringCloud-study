package com.example.orderlistener.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ExcludeRibbonConfig
public class RibbonConfig {

//    @Bean
//    public IRule random(){
//        return new RandomRule();
//    }


    @Bean IRule pingfen(){
        return new MyRibbonRule();
    }




}
