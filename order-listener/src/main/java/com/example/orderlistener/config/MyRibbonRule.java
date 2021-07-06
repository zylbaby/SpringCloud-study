package com.example.orderlistener.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRibbonRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    public Server choseServer(ILoadBalancer lb,Object key){
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server==null){
            List<Server> allServers = lb.getAllServers();
            List<Server> upServers = lb.getReachableServers();
            int serverCount = upServers.size();
            if(serverCount==0){
                return null;
            }
          server= chooseServerForRandom(upServers);
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return null;
    }
    private Server chooseServerForRandom(List<Server> upServers) {
        Random random=new Random();
        int i = random.nextInt(10);
        Server server=null;
        if(i<7){
            server = upServers.get(0);
        }else{
            server=upServers.get(1);
        }
        return server;

    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        return choseServer(loadBalancer,key);
    }
}
