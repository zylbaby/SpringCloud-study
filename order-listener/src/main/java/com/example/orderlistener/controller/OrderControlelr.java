package com.example.orderlistener.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@RestController("/order")
public class OrderControlelr {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/sendMessage")
    public String sendMessage(String phone){
        List<ServiceInstance> sms = discoveryClient.getInstances("sms");
        ServiceInstance serviceInstance = sms.get(0);
        String url="http://sms/getCode";
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String,String>(1);
        param.add("phone", phone);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url,param,String.class);
        String body = stringResponseEntity.getBody();
        return body;
    }

}
