package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]") public WebElement yourShoppingCart;
    @FindBy(xpath = "//*[@id=\"order_step\"]/li[1]/span") public WebElement Summary;
    @FindBy(xpath = "//*[@id=\"product_1_1_0_0\"]/td[2]/p/a") public WebElement Description;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[2]") public WebElement continueShoppingButton;
    @FindBy(xpath = "//*[@id=\"1_1_0_0\"]/i") public WebElement removeProduct;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p") public WebElement cartEmptyMessage;

    public void clickContinueShopping(){
        isElementDisplayed(continueShoppingButton);
        continueShoppingButton.click();
    }
    public void clickRemoveProduct(){
        isElementDisplayed(removeProduct);
        removeProduct.click();
    }




}
