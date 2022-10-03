package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "cart_summary") public WebElement tableWith_product;
    @FindBy(xpath = "//*[@id=\"step_end\"]/span") public WebElement description_Payment;



    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span") public WebElement checkout_btn_summary;
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span") public WebElement checkout_btn_address;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span") public WebElement checkout_btn_shipping;
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a") public WebElement checkout_btn_payByCheck;
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span") public WebElement confirmOrder_btn;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p/a") public WebElement backToOrders_btn;
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1") public WebElement ordersTable_header;
    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[1]/h3") public WebElement yourDeliveryAddress;
    @FindBy(xpath = "//*[@id=\"address_invoice\"]/li[1]/h3") public WebElement billingAddress;
    @FindBy(xpath = "//*[@id=\"form\"]/div/p[1]") public WebElement terms_shipping;
    @FindBy(xpath = "//*[@id=\"cgv\"]") public WebElement terms_checkbox;
    @FindBy(xpath = "//*[@id=\"cart_summary\"]/tfoot/tr[6]/td[1]/span") public WebElement totalText;
    @FindBy(xpath = "//*[@id=\"total_price\"]") public WebElement totalPrice;
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/div/p[1]/strong") public WebElement importantMessage;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]") public WebElement completeMessage;
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/span") public WebElement orderReference;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p") public WebElement cartEmptyMessage;

}
