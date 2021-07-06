package com.example.sms.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

import java.util.List;

@Mapper
public interface RuleMapper {

    List<Map> selectData();
}
