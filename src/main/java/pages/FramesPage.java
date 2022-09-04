package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BasePage {

    WebDriver driver;
    public FramesPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    public void switchToArea(){
        driver.switchTo().alert();
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public String getTextFromArea(WebElement element){
        switchToArea();
        String text = element.getText();
        switchToMainArea();
        return text;
    }
}
