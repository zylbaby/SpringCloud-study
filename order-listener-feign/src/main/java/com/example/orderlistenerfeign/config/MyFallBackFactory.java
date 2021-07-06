package com.example.orderlistenerfeign.config;

import com.example.orderlistenerfeign.service.OrderService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackFactory implements FallbackFactory<OrderService> {

    @Override
    public OrderService create(Throwable cause) {
        cause.printStackTrace();
        System.out.println("服务捕捉异常:"+cause.getMessage());
        OrderService orderService = new OrderService() {
            public String sendMessage(String phone) {
                return "yichang";
            }
        };
        return orderService;

    }
}
