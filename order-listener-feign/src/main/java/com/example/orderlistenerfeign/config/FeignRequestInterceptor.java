package com.example.orderlistenerfeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization","Basic cm9vdDpyb290");
    }
}
