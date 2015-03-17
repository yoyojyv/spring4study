package com.apress.isf.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yoyojyv on 3/17/15.
 */
@Controller
@EnableAutoConfiguration
public class HelloWorldController {

    // run
    // ./gradlew :ch01:run -DmainClass=com.apress.isf.spring.HelloWorldController

    // open browser http://localhost:8080

    @RequestMapping("/")
    @ResponseBody
    String getMessage() {
        return "<h1>Hello World</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }

}
