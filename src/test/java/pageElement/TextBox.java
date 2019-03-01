package pageElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class TextBox extends PageElementModel {
    private static final Log log = LogFactory.getLog(TextBox.class);

    public TextBox(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void type(String inputText) {
        log.info("ABOUT TO TYPE TEXTBOX " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
        try {
            we.sendKeys(inputText);
        } catch (Exception e) {
            String error = "COULD NOT TYPE TEXTBOX: " + getLoggingName() + " TEXT IS: " + inputText;
            log.error(error);
            throw new WebDriverException(error);
        }
    }

    public void waitUntilVisibleAndType(String inputText, int... timeOut) {
        log.info("WAITING FOR TEXTBOX: " + getLoggingName());
        waitUntilVisible(timeOut);
        type(inputText);
    }

    public void clearText() {
        log.info("ABOUT TO CLEAR TEXTBOX " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
        we.clear();
    }

    public void sendEnter() {
        log.info("ABOUT TO TYPE ENTER " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e) {
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
        try {
            we.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            String error = "COULD NOT ENTER TEXTBOX: " + getLoggingName();
            log.error(error);
            throw new WebDriverException(error);
        }
    }

    public String getLabelText() {
        return getWebElement().getText();
    }
}
