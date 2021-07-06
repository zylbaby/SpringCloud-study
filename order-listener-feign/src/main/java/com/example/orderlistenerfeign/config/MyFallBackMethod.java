package com.example.orderlistenerfeign.config;

import com.example.orderlistenerfeign.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackMethod implements OrderService {
    @Override
    public String sendMessage(String phone) {
        System.out.println("不好意思，command 熔断");
        return "熔断了";
    }
}
