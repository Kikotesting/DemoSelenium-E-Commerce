package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]") public WebElement productPage_breadcrumb;
    @FindBy(id = "our_price_display") public WebElement productPrice;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1") public WebElement productHeader;
    @FindBy(xpath = "//*[@id=\"group_1\"]") public WebElement productSize_dropdown;
    @FindBy(xpath = "//*[@id=\"color_15\"]") public WebElement productColor_green;
    @FindBy(xpath = "//*[@id=\"view_full_size\"]/span") public WebElement productZoom_btn;
    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/a") public WebElement productZoom_btnClose;



}
