package com.example.orderlistener.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestController {


    public static void main(String[] args) {
        List test;
        Boolean a=true;
        if(a==Boolean.TRUE){

        }
        //CollectionUtils.isEmpty();
     //   System.out.println(test.size());;
//        List<Map<String,Object>> clientTotal;
//        Map clientTotalMap = new HashMap();
//        List clientTotal2 = new ArrayList();
//        //top55各省个数tip显示客户明细
//        if(idcResourceBandwidthMapper.getClientDetails(in) != null){
//            clientTotal = idcResourceBandwidthMapper.getClientDetails(in);
//            for(int i = 0; i < clientTotal.size(); i++){
//                Map<String, Object> stringObjectMap = clientTotal.get(i);
//                log.info("top55各省个数tip显示客户数:"+clientTotal.size());
//                log.info("params.get(\"resourceType\")="+params.get("resourceType"));
//                log.info("clientTotal.get("+i+")="+clientTotal.get(i).toString());
//                log.info("clientTotal.get("+i+").get(\"resourceCode\").toString()="+clientTotal.get(i).get("resourceCode").toString());
//                if( Integer.parseInt(params.get("resourceType")) == 0 ){
//                    in.put("provinceCode",clientTotal.get(i).get("resourceCode").toString());
//                }
//                else if(Integer.parseInt(params.get("resourceType")) == 1){
//                    //省
//                    in.put("cityCode",clientTotal.get(i).get("resourceCode").toString());
//
//                    if(params.get("resourceCode").equals("310000")||params.get("resourceCode").equals("110000")
//                            ||params.get("resourceCode").equals("120000")||params.get("resourceCode").equals("500000")){
//
//                        in.put("cityCode",clientTotal.get(i).get("resourceCode").toString());
//                    }
//                }
//                else if(Integer.parseInt(params.get("resourceType")) == 2){
//                    //市区
//                    in.put("county_code",clientTotal.get(i).get("resourceCode").toString());
//                }
//                if(idcResourceTop55Mapper.getClientTop55Details(in)!=null){
//                    stringObjectMap.put("list", idcResourceTop55Mapper.getClientTop55Details(in));
//                }
//            }
//            log.info("clientTotal+clientTotal2前=【"+clientTotal.toString()+"】");
//            log.info("clientTotal+clientTotal2后=【"+clientTotal.toString()+"】");
//            total.addAll(clientTotal);
//        }
    }

}
