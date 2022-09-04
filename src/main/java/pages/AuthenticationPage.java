package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {
    WebDriver driver;
    public AuthenticationPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    //Creating users
    @FindBy(className = "email_create") public WebElement emailAddressField;
    @FindBy(className = "icon-user left") public WebElement createAccountButton;

    //Registered users
    @FindBy(name = "email") public WebElement alreadyRegisteredEmail;
    @FindBy(name = "passwd") public WebElement alreadyRegisteredPass;
    @FindBy(className = "icon-lock left") public WebElement signInButton;
    @FindBy(linkText = "Forgot your password?") public WebElement forgotPasswordLink;


}
