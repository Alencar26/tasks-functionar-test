package io.al3ncar.tasks.prod;

import io.al3ncar.tasks.functional.core.BaseTest;
import io.al3ncar.tasks.functional.page.TasksPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.al3ncar.tasks.functional.core.DriverFactory.getDriver;

public class HealthCheckIT extends BaseTest {

    final String URL = "http://localhost:9999/tasks/";
    private TasksPage page;

    @Before
    public void inicializar() {
        getDriver().get(URL);
        page = new TasksPage();
    }

    @Test
    public void healthCheck() {
        Assert.assertTrue(page.validarBuildDeProducao().startsWith("build"));
    }
}
