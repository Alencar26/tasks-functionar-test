package io.al3ncar.tasks.functional.core;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finalizar() throws InterruptedException {
        //Thread.sleep(500);
        DriverFactory.killDriver();
    }
}
