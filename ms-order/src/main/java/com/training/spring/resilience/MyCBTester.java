package com.training.spring.resilience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreaker.EventPublisher;
import io.github.resilience4j.circuitbreaker.CircuitBreaker.Metrics;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Component
public class MyCBTester implements CommandLineRunner {

    @Autowired
    private CallMe                 call;

    @Autowired
    private CircuitBreakerRegistry cbr;

    @Override
    public void run(final String... argsParam) throws Exception {
        //        RetryConfig buildLoc = RetryConfig.custom()
        //                                          .maxAttempts(4)
        //                                          .build();
        //        io.github.resilience4j.retry.Retry retry2Loc = RetryRegistry.of(buildLoc)
        //                                                                    .retry("xyz");
        //        retry2Loc.executeRunnable(() -> this.call.test("test"));
        CircuitBreaker circuitBreakerLoc = this.cbr.circuitBreaker("mycb");
        EventPublisher eventPublisherLoc = circuitBreakerLoc.getEventPublisher();
        eventPublisherLoc.onSuccess(e -> System.out.println("Failure success : " + e.toString()));
        eventPublisherLoc.onFailureRateExceeded(e -> System.out.println("Failure rate : " + e.toString()));
        Metrics metricsLoc = circuitBreakerLoc.getMetrics();
        for (int iLoc = 0; iLoc < 30; iLoc++) {
            System.out.println("Index : "
                               + iLoc
                               + " state : "
                               + circuitBreakerLoc.getState()
                               + " success : "
                               + metricsLoc.getNumberOfSuccessfulCalls()
                               + " failure Rate : "
                               + metricsLoc.getFailureRate()
                               + " slow : "
                               + metricsLoc.getNumberOfSlowCalls()
                               + " slowF : "
                               + metricsLoc.getNumberOfSlowFailedCalls()
                               + " slowS : "
                               + metricsLoc.getNumberOfSlowSuccessfulCalls());
            try {
                System.out.println(this.call.testCB("test" + iLoc));
            } catch (Exception eLoc) {
                // System.err.println("Error calling : " + eLoc.getMessage());
            }
        }
    }

}
