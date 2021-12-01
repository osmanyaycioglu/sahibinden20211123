package com.training.spring.resilience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Component
public class MyRetryTester implements CommandLineRunner {

    @Autowired
    private CallMe call;

    @Override
    public void run(final String... argsParam) throws Exception {
        //        RetryConfig buildLoc = RetryConfig.custom()
        //                                          .maxAttempts(4)
        //                                          .build();
        //        io.github.resilience4j.retry.Retry retry2Loc = RetryRegistry.of(buildLoc)
        //                                                                    .retry("xyz");
        //        retry2Loc.executeRunnable(() -> this.call.test("test"));


        for (int iLoc = 0; iLoc < 30; iLoc++) {
            try {
                System.out.println(this.call.test("test" + iLoc));
            } catch (Exception eLoc) {
                eLoc.printStackTrace();
                System.err.println("Error calling : " + eLoc.getMessage());
            }
        }
    }

}
