package com.apress.isf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yoyojyv on 3/17/15.
 */
@Configuration
@ComponentScan
public class Application {

    // run
    // $ ./gradlew :ch01:run -DmainClass=com.apress.isf.spring.Application

    @Bean
    MessageService helloWorldMessageService() {
        return new HelloWorldMessage();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        MessageService service = context.getBean(MessageService.class);
        System.out.println(service.getMessage());
    }


}
