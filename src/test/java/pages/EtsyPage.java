package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class EtsyPage  {

    public EtsyPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(css = "ul[class$='space-between']>li")
    public List<WebElement> etsyToolBar;
}
