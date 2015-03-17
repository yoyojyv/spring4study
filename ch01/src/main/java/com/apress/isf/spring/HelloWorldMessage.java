package com.apress.isf.spring;

/**
 * Created by yoyojyv on 3/17/15.
 */
public class HelloWorldMessage implements MessageService {

    @Override
    public String getMessage() {
        return "Hello World";
    }

}
