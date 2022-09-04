package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
    WebDriver driver;
    public AccountPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }


}
