package utils.driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver webDriver;

    @BeforeSuite
    public void initializeDriver() {
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().pageLoadTimeout((long) 60, TimeUnit.SECONDS);
        webDriver.get("https://www.trendyol.com");
        webDriver.manage().window().maximize();
    }

    @AfterSuite
    public void closeDriver() {
        webDriver.quit();
    }
}

