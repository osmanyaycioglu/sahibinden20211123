package com.training.spring;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class MyBean {

    private int count;

    public String hello() {
        return "Hello " + this.count++;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroyed");
    }

}
