package com.training.spring.resilience;

import java.util.function.Predicate;

public class MyRetryPredicate implements Predicate<String> {

    @Override
    public boolean test(final String tParam) {
        System.out.println("retry functional deneme");
        return false;
    }

}
