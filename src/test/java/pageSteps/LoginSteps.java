package pageSteps;

import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import pages.HomePage;
import pages.LoginPopUp;

public class LoginSteps {

    HomePage homePage = HomePage.getInstance();
    LoginPopUp loginPopUp = LoginPopUp.getInstance();

    @Step("CLICK CLOSE BUTTON OPENED POPUP")
    public void clickCloseButtonOpenedMenu() {
        homePage.clickPopUpClose();
        homePage.verifyLogin();
    }

    @Step("CLICK LOGIN BUTTON ON THE HOMEPAGE")
    public void clickLoginButtonOnHomePage() {
        homePage.clickLogin();
        loginPopUp.verifyLogin();
    }

    @Step("ENTER EMAIL FIELD <Email> ON THE POP UP PAGE")
    public void enterEmail(String Email) {
        loginPopUp.enterEmailField(Email);
    }

    @Step("ENTER PASSWORD FIELD <Password> ON THE POP UP PAGE")
    public void enterPassword(String Password) {
        loginPopUp.enterPasswordField(Password);
    }

    @Step("USER MUST HAVE LOGGED IN TO THE WEBSITE")
    public void verifyLoggedIn() {
        homePage.clickMyAccount();
        homePage.verifyUserEmail(loginPopUp.getUserData("email"));
    }

    @Step("CLICK LOGIN BUTTON ON THE POP UP PAGE")
    public void clickLoginButtonPopUpPage() {
        loginPopUp.clickLogin();
        homePage.verifyMyAccount("Hesabım");
    }

    @Step("VERIFY THAT <Error> ERROR")
    public void verifyError(String Error) {
        loginPopUp.verifyErrorBox(Error);
    }

    @ContinueOnFailure
    @Step("ENTER INVALID EMAILS IN THE FIELD AND CLICK LOGIN BUTTON <emailTable>")
    public void enterInvalidEmail(Table emailTable) {
        for (TableRow row : emailTable.getTableRows()) {
            loginPopUp.enterEmailField(row.getCell("Email"));
            loginPopUp.clickLogin();
            loginPopUp.verifyErrorBox(row.getCell("Error"));
        }
    }
}
