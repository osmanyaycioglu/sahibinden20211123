package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NodeDiscoveryApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NodeDiscoveryApplication.class,
                              args);
    }

}
