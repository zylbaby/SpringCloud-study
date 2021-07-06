package com.example.eureka.listener;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

@Component
public class TestEvent {

    public void listen(EurekaInstanceCanceledEvent event){
        String appName = event.getAppName();
        String serverId = event.getServerId();
        System.out.println(appName+"下线了，serviceID:"+serverId);

    }
}
