package utils.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("ALL")
public class DriverFactory {

    public static WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver();
        }
        switch (browser) {
            case "IE":
                InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability("ignoreZoomSetting", true);
                return new InternetExplorerDriver(capabilities);
            case "FIREFOX":
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                return new FirefoxDriver();
            default:
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--allow-running-insecure-content");
                ChromeDriver chromeDriver = new ChromeDriver(options);
                return chromeDriver;

        }
    }
}
