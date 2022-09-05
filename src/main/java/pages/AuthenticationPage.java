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
    @FindBy(xpath = "//*[@id=\"email_create\"]") public WebElement emailAddressField;
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span") public WebElement createAccountButton;

    //Registered users
    @FindBy(name = "email") public WebElement alreadyRegisteredEmail;
    @FindBy(name = "passwd") public WebElement alreadyRegisteredPass;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span") public WebElement signInButton;
    @FindBy(linkText = "Forgot your password?") public WebElement forgotPasswordLink;


    public void setEmailAddress(String email){
        emailAddressField.click();
        emailAddressField.sendKeys(email);
    }
    public void clickCreateAccountButton(){
        isElementDisplayed(createAccountButton);
        createAccountButton.click();
    }

    public void setRegisteredMail(String email){
        alreadyRegisteredEmail.clear();
        alreadyRegisteredEmail.sendKeys(email);
    }
    public void setRegisteredPass(String password){
        alreadyRegisteredPass.clear();
        alreadyRegisteredPass.sendKeys("Kiko123@");
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
