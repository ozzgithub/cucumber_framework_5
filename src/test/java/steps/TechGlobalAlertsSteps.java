package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utils.Driver;

public class TechGlobalAlertsSteps {


    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
    }


    @When("user clicks on Practices dropdown in the header")
    public void user_Clicks_On_Practices_Dropdown_In_TheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }


    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        techGlobalFrontendTestingHomePage.clickOnCard(option);
    }


    @Then("user should see buttons as {string}, {string}, and {string}")
    public void user_should_see_buttons_as_and(String alerts) {

        switch (alerts) {
            case "Warning alert":
                techGlobalAlertsPage.alertButtons.get(0).isDisplayed();
                break;
            case "Confirmation alert":
                techGlobalAlertsPage.alertButtons.get(1).isDisplayed();
                break;

            case "Prompt alert":
                techGlobalAlertsPage.alertButtons.get(2).isDisplayed();
                break;
            default:
                throw new NotFoundException();
        }

    }

    @Then("user should see {string} text")
    public void user_should_see_text(String string) {

        Assert.assertTrue(techGlobalAlertsPage.resultTitle.isDisplayed());
    }

    @When("user clicks on {string} box")
    public void user_clicks_on_box() {

        techGlobalAlertsPage.alertButtons.get(0).click();

    }

    @Then("user should see a popup displaying message {string}")
    public void user_should_see_a_popup_displaying_message(String text) {

        Assert.assertEquals(text , techGlobalAlertsPage.result.getText());

    }

}
