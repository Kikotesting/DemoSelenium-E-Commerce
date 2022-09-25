package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenPage extends BasePage {
    public WomenPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/h2") public WebElement womenRightBlockTitle;
    @FindBy(xpath = "//*[@id=\"layered_form\"]/div/div[10]/div/span") public WebElement filterHeaderPrice;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[1]/ul/li[1]") public WebElement viewTypes;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[2]/div[2]") public WebElement showingResults;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div") public WebElement firstProductGridView;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div") public WebElement firstProductListView;

    //Submenus
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/span")  public WebElement submenu_DressesDropdown;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[3]/a")  public WebElement submenu_DressesDropdown_SummerDresses;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")  public WebElement submenu_TopsDropdown;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[2]/a")  public WebElement submenu_TopsDropdown_Blouses;

    //View buttons
    @FindBy(xpath = "//*[@id=\"grid\"]/a/i") public WebElement gridBtn;
    @FindBy(xpath = "//*[@id=\"list\"]/a/i") public WebElement listBtn;

    //Filter from catalogue
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]/span") public WebElement enabledFilters;
    @FindBy(xpath = "//*[@id=\"ul_layered_category_0\"]/li[2]/label/a") public WebElement filterDresses;
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]/ul/li/a") public WebElement removeFilter;
    @FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li[3]/label/a") public WebElement filterColorBlack;
    @FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[1]") public WebElement leftSliderPrice;

    public void clickGridView(){
        gridBtn.click();
    }
    public void clickListView(){
        listBtn.click();
    }
    public void clickFilterDresses(){
        filterDresses.click();
    }
    public void clickFilterBlackColor(){
        filterColorBlack.click();
    }
    public void clickRemoveFilter(){
        isElementDisplayed(removeFilter);
        removeFilter.click();
    }
    public void setSliderValue(String value){
        for (int i = 1; i <= 10 ; i++) {
            leftSliderPrice.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void waitRefreshedResultText(int seconds, WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.
                textToBe(By.xpath("//*[@id=\"center_column\"]/div[4]/div/div[2]")
                        ,text)));
    }

}
