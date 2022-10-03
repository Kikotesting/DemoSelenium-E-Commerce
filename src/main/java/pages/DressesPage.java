package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage extends BasePage {
    public DressesPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"layered_block_left\"]/p") public WebElement leftMenuCatalog_Header;
    @FindBy(xpath = "//*[@id=\"list\"]/a/i") public WebElement  list_btn;

    @FindBy(className = "subcategory-heading") public WebElement subcategoriesMenu_Header;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[2]/div[2]") public WebElement showingResults;
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]") public WebElement enabledFilters;
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]/ul") public WebElement enabledFiltersList;
    @FindBy(xpath = "//*[@id=\"layered_id_feature_5\"]") public WebElement cottonFilter;
    @FindBy(xpath = "//*[@class=\"button ajax_add_to_cart_button btn btn-default\"]") public WebElement addCart_btn_PrintedDress;
    public void waitRefreshedResultText(WebElement element, int seconds,String text){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.
                textToBePresentInElement(element,text)));
    }
}
