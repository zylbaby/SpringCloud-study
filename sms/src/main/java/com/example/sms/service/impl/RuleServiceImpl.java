package com.example.sms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.sms.mapper.RuleMapper;
import com.example.sms.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public List<Map> selectData() {
        List<Map> rule=ruleMapper.selectData();
        return rule;
    }
}
