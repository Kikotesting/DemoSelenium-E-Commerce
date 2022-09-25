package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    //Creating users
    @FindBy(id = "email_create") public WebElement emailAddressForCreateAccount_field;
    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span") public WebElement createAccountButton;

    //Registered users
    @FindBy(name = "email") public WebElement alreadyRegisteredEmail;
    @FindBy(name = "passwd") public WebElement alreadyRegisteredPass;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span") public WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol")public WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")public WebElement accErrorMessage;
    @FindBy(linkText = "Forgot your password?") public WebElement forgotPasswordLink;

    public void clickCreateAccount_btn(){
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
