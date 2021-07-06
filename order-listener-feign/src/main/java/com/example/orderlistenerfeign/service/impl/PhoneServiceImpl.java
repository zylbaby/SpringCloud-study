package com.example.orderlistenerfeign.service.impl;

import com.example.orderlistenerfeign.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Override
    public  String getPhone(String userId) {
        synchronized(userId){
            System.out.println(Thread.currentThread().getName()+"取到了锁");
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
        return "测试";
    }
}
