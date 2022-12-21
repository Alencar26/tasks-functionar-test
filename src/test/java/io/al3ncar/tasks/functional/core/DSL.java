package io.al3ncar.tasks.functional.core;

import org.openqa.selenium.By;

import static io.al3ncar.tasks.functional.core.DriverFactory.getDriver;

public class DSL {

    public void clicarBotaoPorId(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void escreverById(String id ,String texto) {
        escrever(By.id(id), texto);
    }

    public String validarTexto(String id) {
        return getDriver().findElement(By.id(id)).getText();
    }
}
