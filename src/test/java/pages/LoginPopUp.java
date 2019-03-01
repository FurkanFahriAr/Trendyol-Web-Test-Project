package pages;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import pageElement.Button;
import pageElement.Label;
import pageElement.PageElementModel;
import pageElement.TextBox;

public class LoginPopUp {
    private static final Log log = LogFactory.getLog(LoginPopUp.class);
    private static LoginPopUp instance;

    private static TextBox txtEmailField = new TextBox(PageElementModel.selectorNames.XPATH, "//*[@id=\"email\"]");
    private static TextBox txtPasswordField = new TextBox(PageElementModel.selectorNames.XPATH, "//*[@id=\"password\"]");
    private static Button btnLogin = new Button(PageElementModel.selectorNames.XPATH, "//*[@id=\"loginSubmit\"]");
    private static Label lblLoginPopUpTitle = new Label(PageElementModel.selectorNames.XPATH, "//*[@id=\"popupLoginMain\"]/h2");
    private static Label lblErrorBox = new Label(PageElementModel.selectorNames.ID, "errorBox");

    private DataStore emailStore = DataStoreFactory.getScenarioDataStore();

    public static synchronized LoginPopUp getInstance() {
        if (instance == null) {
            instance = new LoginPopUp();
        }
        return instance;
    }

    public void verifyErrorBox(String expected) {
        log.info("Verifying ErrorBox With " + emailStore.get("email"));
        try {
            Assert.assertEquals(expected, getTextErrorBox());
        } catch (WebDriverException e) {
            log.warn("Could not verify ErrorBox With" + emailStore.get("email") + "Label");
        }
    }

    public String getTextErrorBox() {
        log.info("Getting text ErrorBox Label");
        try {
            return lblErrorBox.getLabelText();
        } catch (WebDriverException e) {
            log.warn("Could not get text ErrorBox Label");
            return null;
        }
    }

    public void enterEmailField(String keyword) {
        log.info("Enter field txtEmailField Textbox");
        try {
            txtEmailField.clearText();
            txtEmailField.type(keyword);
            emailStore.put("email", keyword);
        } catch (WebDriverException e) {
            log.error("Could not enter txtEmailField TextBox");
        }
    }

    public String getUserData(String key) {
        return (String) emailStore.get(key);
    }

    public void enterPasswordField(String keyword) {
        log.info("Enter field PasswordField Textbox");
        try {
            txtPasswordField.type(keyword);
        } catch (WebDriverException e) {
            log.error("Could not enter PasswordField TextBox");
        }
    }

    public void clickLogin() {
        log.info("Clicking Login Button");
        try {
            btnLogin.clickAndWait(5);
        } catch (WebDriverException e) {
            log.warn("Could not click Login Button");
        }
    }

    public void verifyLogin() {
        log.info("Verifying Login Button");
        try {
            Assert.assertTrue(btnLogin.isDisplayed());
        } catch (WebDriverException e) {
            log.warn("Could not verify Login Button");
        }
    }

    public void verifyLoginPopUpTitle(String expected) {
        log.info("Verifying LoginPopUpTitle Label");
        try {
            Assert.assertEquals(expected, getTextLoginPopUpTitle());
        } catch (WebDriverException e) {
            log.warn("Could not verify LoginPopUpTitle Label");
        }
    }

    public String getTextLoginPopUpTitle() {
        log.info("Getting text LoginPopUpTitle Label");
        try {
            return lblLoginPopUpTitle.getLabelText();
        } catch (WebDriverException e) {
            log.warn("Could not get text LoginPopUpTitle Label");
            return null;
        }
    }

}
