package io.al3ncar.tasks.functional.core;

import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };
    private DriverFactory() {};

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "/home/al3ncar/www/drivers-selenium/chromedriver_linux64/chromedriver");
        try {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL("http://172.19.0.1:4444/wd/hub"), cap);
        } catch(Exception e) {
            System.out.println("Houve um erro no GRID - " + e.getMessage());

        //driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        }
        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver!= null) {
            driver.quit();
            driver = null;
        }
        if (driverThread != null) {
            driverThread.remove();
        }
    }
}
