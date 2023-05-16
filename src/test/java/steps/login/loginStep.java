package steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {
    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        System.out.println("33333333333333333333333333333333333333333333333333");
    }

    @When("^I enter my username and password$")
    public void iEnterMyUsernameAndPassword() {
    }

    @And("^I click the Login button$")
    public void iClickTheLoginButton() {
    }

    @Then("^I should be taken to the Dashboard page$")
    public void iShouldBeTakenToTheDashboardPage() {
    }

    @And("^I should see the \"([^\"]*)\" menu$")
    public void iShouldSeeTheMenu(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
