package com.training.spring.resilience;

import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.Retry.Metrics;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;

@Component
public class CallMe {

    private int                    counter = 0;

    @Autowired
    private RetryRegistry          rr;

    @Autowired
    private CircuitBreakerRegistry cbr;

    @CircuitBreaker(name = "mycb")
    public String testCB(final String name) {
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalArgumentException("problem");
        }
        if ((this.counter % 4) == 0) {
            try {
                Thread.sleep(1_000);
            } catch (Exception eLoc) {
            }
        }
        return "OK-" + name;
    }


    @Retry(name = "myretry", fallbackMethod = "testFallback")
    public String test(final String name) {
        io.github.resilience4j.retry.Retry retryLoc = this.rr.retry("myretry");
        Metrics metricsLoc = retryLoc.getMetrics();
        System.out.println("rf : "
                           + metricsLoc.getNumberOfFailedCallsWithoutRetryAttempt()
                           + "rrf : "
                           + metricsLoc.getNumberOfFailedCallsWithRetryAttempt()
                           + " s : "
                           + metricsLoc.getNumberOfSuccessfulCallsWithoutRetryAttempt()
                           + " sr : "
                           + metricsLoc.getNumberOfSuccessfulCallsWithRetryAttempt());
        this.counter++;
        if ((this.counter % 3) == 0) {
            throw new IllegalArgumentException("problem");
        }
        if ((this.counter % 4) == 0) {
            throw new NullArgumentException("null problem");
        }
        return "OK-" + name;
    }

    public String testFallback(final String name,
                               final Throwable throwable) {
        System.out.println("Retry test Fallback ");
        return "OK";
    }
}
