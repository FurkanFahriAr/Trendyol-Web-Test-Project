package pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import pageElement.Button;
import pageElement.Label;
import pageElement.PageElementModel;

public class HomePage {
    private static final Log log = LogFactory.getLog(HomePage.class);
    private static HomePage instance;
    private static Button btnLogin = new Button(PageElementModel.selectorNames.XPATH, "//*[@id=\"not-logged-in-container\"]");
    private static Button btnMyAccount = new Button(PageElementModel.selectorNames.ID, "logged-in-container");
    private static Label lblUserEmail = new Label(PageElementModel.selectorNames.CLASS_NAME, "user-email");
    private static Button btnPopUpClose = new Button(PageElementModel.selectorNames.XPATH, "//*[@title=\"Kapat\"]");


    public static synchronized HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }

    public void clickPopUpClose() {
        log.info("Clicking btnPopUpClose Button");
        try {
            btnPopUpClose.waitUntilVisibleAndClick();
        } catch (WebDriverException e) {
            log.warn("Could not click btnPopUpClose Button");
        }
    }

    public void verifyMyAccount(String expected) {
        log.info("Verifying MyAccount Label");
        try {
            Assert.assertEquals(expected, getTextMyAccount());
        } catch (WebDriverException e) {
            log.warn("Could not verify MyAccount Label");
        }
    }

    public String getTextMyAccount() {
        log.info("Getting text MyAccount Label");
        try {
            return btnMyAccount.getButtonText();
        } catch (WebDriverException e) {
            log.warn("Could not get text MyAccount Label");
            return null;
        }
    }

    public void verifybtnPopUpClose() {
        log.info("Verifying btnPopUpClose Button");
        try {
            Assert.assertTrue(btnPopUpClose.isDisplayed());
        } catch (WebDriverException e) {
            log.warn("Could not verify btnPopUpClose Button");
        }
    }

    public void verifyUserEmail(String expected) {
        log.info("Verifying UserEmail Label");
        try {
            Assert.assertEquals(expected, getTextUserEmail());
        } catch (WebDriverException e) {
            log.warn("Could not verify UserEmail Label");
        }
    }

    public String getTextUserEmail() {
        log.info("Getting text UserEmail Label");
        try {
            return lblUserEmail.getLabelText();
        } catch (WebDriverException e) {
            log.warn("Could not get text UserEmail Label");
            return null;
        }
    }

    public void clickMyAccount() {
        log.info("Clicking MyAccount Button");
        try {
            btnMyAccount.waitUntilVisibleAndClick();
        } catch (WebDriverException e) {
            log.warn("Could not click MyAccount Button");
        }
    }

    public void verifyMyAccount() {
        log.info("Verifying MyAccount Button");
        try {
            Assert.assertTrue(btnMyAccount.isDisplayed());
        } catch (WebDriverException e) {
            log.warn("Could not verify MyAccount Button");
        }
    }

    public void clickLogin() {
        log.info("Clicking btnLogin Button");
        try {
            btnLogin.clickAndWait(3);
        } catch (WebDriverException e) {
            log.warn("Could not click btnLogin Button");
        }
    }

    public void verifyLogin() {
        log.info("Verifying btnLogin Button");
        try {
            Assert.assertTrue(btnLogin.isDisplayed());
        } catch (WebDriverException e) {
            log.warn("Could not verify btnLogin Button");
        }
    }
}