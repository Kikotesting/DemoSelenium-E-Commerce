package pages;

import basePage.BasePage;
import custom.Highlighter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WomenPage extends BasePage {
    public WomenPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    //Left block element
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/h2") public WebElement leftHeader_breadcrumbTitle;

    @FindBy(xpath = "//*[@id=\"layered_form\"]/div/div[10]/div/span") public WebElement leftSlider_header;
    private By leftSlider_rangeLeft = By.xpath("//*[@id=\"layered_price_range\"]");
    public By leftSlider_priceLeft = By.xpath("//*[@id=\"layered_price_slider\"]/a[1]");


    // Results
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[2]/div[2]") public WebElement showingResults;


    // Submenus dropdown
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")  public WebElement submenu_Tops;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[1]/a")  public WebElement submenu_Tops_Tshirts;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/ul/li[2]/a")  public WebElement submenu_Tops_Blouses;

    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/span")  public WebElement submenu_Dresses;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[1]/a")  public WebElement submenu_Dresses_Casual;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[2]/a")  public WebElement submenu_Dresses_Evening;
    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/ul/li[3]/a")  public WebElement submenu_Dresses_Summer;


    // View buttons and product elements
    @FindBy(xpath = "//*[@id=\"subcategories\"]") public WebElement subCategories_div;
    @FindBy(xpath = "//*[@id=\"grid\"]/a/i") WebElement grid_btn;
    @FindBy(xpath = "//*[@id=\"list\"]/a/i") WebElement list_btn;
    @FindBy(xpath = "//a[@class=\"product-name\"][contains(text(),'Faded')]") public WebElement product_FadedShortSleeve;
    @FindBy(xpath = "//a[@class=\"product-name\"][contains(text(),'Blouse')]") public WebElement product_Blouse;
    @FindBy(xpath = "//a[@class=\"product-name\"][contains(text(),'Printed Dress')]") public WebElement product_PrintedDress;




    //Filter from catalogue
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]") public WebElement enabledFilters;
    @FindBy(xpath = "//*[@id=\"enabled_filters\"]/ul") public WebElement enabledFiltersList;
    @FindBy(xpath = "//*[@id=\"ul_layered_category_0\"]/li[2]/label/a") public WebElement filterDresses;
    @FindBy(xpath = "//*[@id=\"layered_id_feature_1\"]") public WebElement filterPolyester;
    @FindBy(xpath = "//*[@class='icon-remove'][1]") public WebElement removeFilter;






    public void clickGridViews(){
        isElementDisplayed(grid_btn);
        grid_btn.click();
    }
    public void clickListViews(){
        isElementDisplayed(list_btn);
        list_btn.click();
    }

    public void clickFilterDresses(){
        isElementDisplayed(filterDresses);
        filterDresses.click();
    }
    public void clickFilterPolyester(){
        isElementDisplayed(filterPolyester);
        filterPolyester.click();
    }
    public void kiko(){
        List<WebElement> filters  = driver.findElements(By.xpath("//*[@class='icon-remove']"));
        for (int i = 0; i < filters.size(); i++){
            filters.get(i).click();
            pauseSeconds(5);
        }
    }

    public String getSliderValue(){
        return driver.findElement(leftSlider_rangeLeft).getText();
    }
    public void setSliderValueL(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(leftSlider_priceLeft).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void waitRefreshedResultText(WebElement element, int seconds,String text){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.
                textToBePresentInElement(element,text)));
    }

}
