package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EtsyPage;
import utils.Driver;

public class EtsySteps {


    WebDriver driver;
    EtsyPage etsyPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        etsyPage = new EtsyPage();
    }
    @Then("user should see elements tool bar is displayed")
    public void userShouldSeeToolBarIsDisplayed(DataTable elements) {

        for (int i = 0; i < elements.asList().size(); i++) {
            Assert.assertEquals(elements.asList().get(i),etsyPage.etsyToolBar.get(i).getText());

        }




    }


}
