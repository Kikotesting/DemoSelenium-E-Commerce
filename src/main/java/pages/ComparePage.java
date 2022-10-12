package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage extends BasePage {
    public ComparePage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1") public WebElement header_Text;
    @FindBy(xpath = "//*[@class='icon-trash']") public WebElement removeProduct_btn;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/div[4]") public WebElement productOne;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/div[3]/span") public WebElement productOne_price;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[2]/td[2]") public WebElement productOne_Cotton;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[3]/div[4]") public WebElement productTwo;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[3]/div[3]/span") public WebElement productTwo_price;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[2]/td[3]") public WebElement productTwo_Viscose;
}
