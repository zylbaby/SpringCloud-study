package com.example.orderlistenerfeign.controller;

import com.example.orderlistenerfeign.config.UserLock;
import com.example.orderlistenerfeign.service.OrderService;
import com.example.orderlistenerfeign.service.PhoneService;
import com.example.orderlistenerfeign.service.impl.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/order-feign")
public class OrderControllerFeign {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PhoneService phoneService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/sendMessage")
    public String sendMessage(String phone){
        System.out.println("匹配的服务端口是:"+port);
        String s = orderService.sendMessage(phone);
        return s;
    }

    @PostMapping("/getPhone")
    public String getPhone(String phone){
        System.out.println("请求到达:"+phone);
        return phoneService.getPhone(phone);
    }
    @PostMapping("/login")
    public void login(Long userId) {
        synchronized (UserLock.getLock("login" + userId)) {
            System.out.println("用户正在使用:"+userId);
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(userId+"释放了锁");
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock=new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.signal();
        ReentrantReadWriteLock readLock=new ReentrantReadWriteLock();
//        ReentrantReadWriteLock.ReadLock readLock= new ReentrantReadWriteLock.ReadLock(reentrantReadWriteLock);
//        readLock.lock();
        readLock.readLock().lock();
        reentrantLock.lock();

    }

}
