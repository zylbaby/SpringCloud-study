package com.example.zuulexample.Filter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**ZuulProxyAutoConfiguration
 * 网关的熔断回调
 */
@Component
public class ZuulFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println("route:"+route);
        System.out.println("异常信息:"+cause.getMessage());
        return null;
    }
}
