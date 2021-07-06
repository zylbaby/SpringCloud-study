package com.example.orderlistenerfeign;

import com.example.orderlistenerfeign.config.ExcludeAnnon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.example.orderlistenerfeign"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value= ExcludeAnnon.class)})
public class OrderListenerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderListenerFeignApplication.class, args);
    }

}
