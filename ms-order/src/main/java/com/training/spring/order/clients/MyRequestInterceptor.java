package com.training.spring.order.clients;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;

public class MyRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(final RequestTemplate templateParam) {
        Target<?> feignTargetLoc = templateParam.feignTarget();
        String nameLoc = feignTargetLoc.name();
        System.out.println("Target Name : " + nameLoc);
        templateParam.header("X-Origin",
                             "restaurant.subdomain.order.order");
    }

}
