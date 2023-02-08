package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WikipediaPage;
import utils.Driver;

public class WikipediaSteps {
    
    
    WebDriver driver;
    WikipediaPage wikipediaPage;

    @Before
    public void setPage() {
        driver = Driver.getDriver();
        wikipediaPage = new WikipediaPage();
    }

    
    @When("user searches for {string} on Wikipedia")
    public void userSearchesForOnWikipedia(String key) {

        wikipediaPage.searchInput.sendKeys(key + Keys.ENTER);
    }

    @And("user should see {string} in the first heading")
    public void userShouldSeeInTheFirstHeading(String key) {

        Assert.assertTrue(wikipediaPage.heading.isDisplayed());
        Assert.assertEquals(key , wikipediaPage.heading.getText());
    }
}
