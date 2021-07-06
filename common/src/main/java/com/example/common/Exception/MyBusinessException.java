package com.example.common.Exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

public class MyBusinessException extends HystrixBadRequestException {

    private String message;

    public MyBusinessException(String message) {
        super(message);
        this.message=message;
    }
}
