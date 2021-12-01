package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.live.error.ErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@Import(ErrorConfig.class)
public class MsRestaurantImplApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsRestaurantImplApplication.class,
                              args);
    }

}
