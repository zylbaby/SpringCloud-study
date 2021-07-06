package com.example.orderlistenerfeign.service;

import com.example.orderlistenerfeign.config.FeignAuthConfiguration;
import com.example.orderlistenerfeign.config.MyFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sms-message",configuration = FeignAuthConfiguration.class,fallbackFactory = MyFallBackFactory.class)
public interface OrderService {

    //ignoreExceptions = {MyBusinessException.class},
//    @HystrixCommand(commandProperties={
////            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="3000"),
////            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="40"),
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @RequestMapping(value = "/getCode",method = RequestMethod.POST)
    public String sendMessage(@RequestParam(name = "phone") String phone);
}
