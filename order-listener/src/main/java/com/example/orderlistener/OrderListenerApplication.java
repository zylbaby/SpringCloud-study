package com.example.orderlistener;

import com.example.orderlistener.config.ExcludeRibbonConfig;
import com.example.orderlistener.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@RibbonClient(name = "sms",configuration = RibbonConfig.class)
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = ExcludeRibbonConfig.class))
public class OrderListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderListenerApplication.class, args);
    }

}
