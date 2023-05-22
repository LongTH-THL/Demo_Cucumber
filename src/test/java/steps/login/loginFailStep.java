package steps.login;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageUI.LoginPageUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class loginFailStep extends BaseTest {
    public WebDriver driver;
    @Given("^I am on the login page \"([^\"]*)\" in \"([^\"]*)\"$")
    public void userNavigatesToFacebook(String arg0, String arg1) {
        driver = getBrowserDriver(arg0,arg1);
    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void iEnterUsernameAs(String arg0){
        waitForElementVisible(driver, LoginPageUI.USER_NAME);
        sendKeyToElement(driver, LoginPageUI.USER_NAME, arg0);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String arg0){
        waitForElementVisible(driver, LoginPageUI.PASS);
        sendKeyToElement(driver, LoginPageUI.PASS, arg0);
    }

    @And("^I click Login button$")
    public void iClickLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    @Then("^Login should fail$")
    public void loginShouldFail() {
    }



}
