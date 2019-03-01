package pageElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Button extends PageElementModel {
    private static final Log log = LogFactory.getLog(Button.class);

    public Button(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }


    public void click() {
        log.info("ABOUT TO CLICK BUTTON " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
        try {
            we.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK BUTTON: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
    }

    public void waitUntilVisibleAndClick(int... timeOut) {
        log.info("WAITING FOR CLICK BUTTON " + getLoggingName());
        waitUntilVisible(timeOut);
        click();
    }

    public void clickAndWait(int... timeOut) {
        int timeOutI = 5;
        if (timeOut.length != 0) {
            timeOutI = timeOut[0];
        }
        click();
        log.info("WAITING AFTER CLICK BUTTON " + getLoggingName() + " WAIT TIME IS: " + timeOutI);
        try {
            Thread.sleep(timeOutI * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickAndSwitchFocusTab(int... timeOut) {
        log.info("WAITING FOR CLICK BUTTON " + getLoggingName());
        waitUntilVisible(timeOut);
        click();
        Set<String> tab_handles = webdriver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs - 1;
        webdriver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getButtonText() {
        return getWebElement().getText();
    }
}