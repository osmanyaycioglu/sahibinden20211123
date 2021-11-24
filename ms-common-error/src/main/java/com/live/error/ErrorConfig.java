package com.live.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorHandlerAdvice errorHandlerAdvice() {
        return new ErrorHandlerAdvice();
    }

}
