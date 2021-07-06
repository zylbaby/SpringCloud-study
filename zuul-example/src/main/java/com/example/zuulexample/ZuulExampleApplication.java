package com.example.zuulexample;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan("com.example.zuulexample.*")
public class ZuulExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulExampleApplication.class, args);
    }

   /* public static void init() {
        List<FlowRule> flowRuleList=new ArrayList<>();
        FlowRule flowRule=new FlowRule();
        flowRule.set
        flowRule.setResource("order-listener-feign");
        flowRule.setCount(3);
    }*/

}
