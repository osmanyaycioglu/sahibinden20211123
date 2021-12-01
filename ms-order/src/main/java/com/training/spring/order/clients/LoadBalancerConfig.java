package com.training.spring.order.clients;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class LoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(final ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier.builder()
                                          .withBlockingHealthChecks()
                                          .withBlockingDiscoveryClient()
                                          .build(context);
    }

}
