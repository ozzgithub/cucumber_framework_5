package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalLoginFormPage extends TechGlobalBasePage{
    public TechGlobalLoginFormPage() {
        super();
    }



    @FindBy(id = "username")
    public WebElement userNameInput;


    @FindBy(id = "password")
    public WebElement userPasswordInput;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "main_heading")
    public WebElement headingText;

    @FindBy(id = "error_message")
    public WebElement errorMessageText;

    @FindBy(id = "success_lgn")
    public WebElement successLoginText;



}
