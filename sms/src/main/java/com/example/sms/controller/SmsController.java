package com.example.sms.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.common.Exception.MyBusinessException;
import com.example.sms.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class SmsController {

    @Autowired
    RuleService ruleService;

    @PostMapping(value = "/getCode")
    public String getCode(String phone){
        List<Map> maps = ruleService.selectData();
        String s = JSONObject.toJSONString(maps);
//        try{
//            int i=1/0;
//        }catch (Exception e){
//            throw  new MyBusinessException("熔断忽略的异常");
//        }
        return s;
    }
}
