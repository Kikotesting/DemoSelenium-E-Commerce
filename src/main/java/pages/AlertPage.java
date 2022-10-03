package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]") public WebElement addingProduct_layer;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2") public WebElement headerOne_SuccessAddProduct;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/h2/span[2]") public WebElement headerTwo_SuccessAddProduct;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a") public WebElement  proceed_btn;
}
