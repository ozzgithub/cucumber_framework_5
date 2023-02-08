package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utils.AlertHandler;
import utils.Driver;
import utils.Waiter;

public class TechGlobalSteps {


    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @When("user clicks on Practices dropdown in the header")
    public void userClicksOnPracticesDropdownInTheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Dynamic Tables":
            case "Alerts":
            case "Login Form":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException();
        }
    }

    @Then("user should see {string} heading")
    public void userShouldSeeHeading(String headerText) {
        switch (headerText) {
            case "Dynamic Tables":
                Assert.assertEquals(headerText, techGlobalDynamicTablesPage.headingText.getText());
                break;
            case "Alerts":
                Assert.assertEquals(headerText, techGlobalAlertsPage.headingText.getText());
                break;
            case "Login Form":
                Assert.assertEquals(headerText, techGlobalLoginFormPage.headingText.getText());
                break;
            default:
                throw new NotFoundException("The heading text is not defined!");
        }
    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String argument) {
        switch (argument) {
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file");
        }
    }

    @Then("validate {string} pop-up is displayed")
    public void validatePopUpIsDisplayed(String popup) {
        Assert.assertEquals(popup, techGlobalDynamicTablesPage.modalCardTitle.getText());
    }

    @Then("user should not see Add New Product pop-up")
    public void userShouldNotSeeAddNewProductPopUp() {
        try {
            Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }


    @And("user should see buttons as {string}, {string}, and {string}")
    public void userShouldSeeButtonsAsAnd(String alert1, String alert2, String alert3) {
        Assert.assertEquals(alert1, techGlobalAlertsPage.alertButtons.get(0).getText());
        Assert.assertEquals(alert2, techGlobalAlertsPage.alertButtons.get(1).getText());
        Assert.assertEquals(alert3, techGlobalAlertsPage.alertButtons.get(2).getText());
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String resulText) {
        Assert.assertEquals(resulText, techGlobalAlertsPage.resultTitle.getText());
    }

    @When("user clicks on {string} box")
    public void userClicksOnBox(String alertButton) {
        techGlobalAlertsPage.clickOnAlert(alertButton);
    }

    @Then("user should see a popup displaying message {string}")
    public void userShouldSeeAPopupDisplayingMessage(String alertMessage) {
        Waiter.pause(2);
        Assert.assertEquals(alertMessage, AlertHandler.getAlertText());
        Waiter.pause(2);
        AlertHandler.acceptAlert();
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        techGlobalLoginFormPage.userNameInput.sendKeys(username);
        techGlobalLoginFormPage.userPasswordInput.sendKeys(password);
        techGlobalLoginFormPage.loginButton.click();
    }

    @Then("user should see a {string} message")
    public void userShouldSeeAMessage(String errorMessage) {
        switch (errorMessage) {
            case "Invalid Username entered!":
            case "Invalid Password entered!":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.errorMessageText.getText());
                break;
            case "You are logged in":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.successLoginText.getText());
                break;
            default:
                throw new NotFoundException("The error message is not defined properly in the feature file");
        }
    }
}