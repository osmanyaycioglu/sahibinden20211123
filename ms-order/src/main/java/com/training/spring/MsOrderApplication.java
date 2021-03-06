package com.training.spring;

import javax.annotation.PostConstruct;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.live.error.ErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Import(ErrorConfig.class)
public class MsOrderApplication implements ApplicationRunner {

    @Autowired
    private MyBean       myBean1;

    @Autowired
    private MyBean       myBean2;

    @Autowired
    private MyBean       myBean3;

    private final MyBean myBean4;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    public MsOrderApplication(final MyBean myBean4) {
        this.myBean4 = myBean4;
    }

    @PostConstruct
    public void name() {
    }

    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {

        System.out.println(this.myBean1.hello());
        System.out.println(this.myBean2.hello());
        System.out.println(this.myBean3.hello());
        System.out.println(this.myBean4.hello());

        System.out.println(this.myBean1.hello());
        System.out.println(this.myBean2.hello());
        System.out.println(this.myBean4.hello());

    }

}
