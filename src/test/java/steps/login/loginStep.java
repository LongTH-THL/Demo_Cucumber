package steps.login;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageUI.LoginPageUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class loginStep extends BaseTest {
    public WebDriver driver;

    public loginStep(WebDriver driver) {
        this.driver = driver;
    }
    @Given("^I am on the login page \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iAmOnTheLoginPageIn(String arg0, String arg1) throws Throwable {
        driver = getBrowserDriver(arg0,arg1);
    }

    @When("^I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
        waitForAllElementVisible(driver, LoginPageUI.USER_NAME);
        clickToElement(driver, LoginPageUI.USER_NAME);
    }

    @And("^I click the Login button")
    public void iClickTheLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    @Then("^I should be taken to the Dashboard page$")
    public void iShouldBeTakenToTheDashboardPage() {
    }

    @And("^I should see the \"([^\"]*)\" menu$")
    public void iShouldSeeTheMenu(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
