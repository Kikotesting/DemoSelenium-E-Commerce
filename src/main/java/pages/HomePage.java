package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/span") public WebElement leftNavbarCallusNumber;
    @FindBy(className = "container") public WebElement bannerContainer;

    @FindBy(xpath = "//*[@id=\"homeslider\"]/li[2]/a/img") public WebElement bannerPic2;
    @FindBy(xpath = "//*[@id=\"homeslider\"]/li[3]/a/img") public WebElement bannerPic3;


    //Main menu
    @FindBy(linkText = "Women") public WebElement mainMenuWomen;
    @FindBy(linkText = "Dresses") public WebElement mainMenuDresses;
    @FindBy(linkText = "T-shirts") public WebElement mainMenuTshirts;

    //Return to homepage
    @FindBy(className = "logo img-responsive") public WebElement backButtonHome;

    //Cart button
    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a") public WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p") public WebElement cartEmptyMessage;
    //Searchbox
    @FindBy(name = "search_query") public WebElement searchBox;
    @FindBy(name = "submit_search") WebElement submitSearchButton;
    @FindBy(className = "lighter") public WebElement summerDressResult;
    @FindBy(className = "heading-counter") public WebElement headingCounterResults;

    //Account navigation
    @FindBy(className = "login") public WebElement signInButton;
    @FindBy(className = "logout") public WebElement logOutButton;
    @FindBy(linkText = "Contact us") public WebElement navRightContactUs;

    //Nav banner according
    @FindBy(className = "bx-next") public WebElement bannerNext;
    @FindBy(className = "bx-prev") public WebElement bannerPrev;

    //Filters
    @FindBy(className = "blockbestsellers") public WebElement filterButtonBestSellers;
    @FindBy(className = "homefeatured") public WebElement filterButtonPopular;


    // Sort by Highest Price then Reference Highest
    @FindBy(id = "selectProductSort") public WebElement sortDropdown;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a") public WebElement productOne;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a") public WebElement productTwo;


    //Click Elements
    public void clickElement(WebElement elementMenu){
        isElementDisplayed(elementMenu);
        elementMenu.click();
    }
    public void clickBannerArrowNext(){
        isElementDisplayed(bannerNext);
        bannerNext.click();
    }
    public void clickBannerArrowPrev(){
        isElementDisplayed(bannerPrev);
        bannerPrev.click();
    }
    public void clickSearchBoxAndType(String text){
        isElementDisplayed(searchBox);
        searchBox.clear();
        searchBox.sendKeys(text);
    }
    public void submitSearch(){
        isElementDisplayed(submitSearchButton);
        submitSearchButton.click();
    }
    public void clickCartButton(){
        isElementDisplayed(cartButton);
        cartButton.click();
    }
    public void clickSortDropdown(){
        isElementDisplayed(sortDropdown);
        sortDropdown.click();
    }
    public void selectValueHighestFirst(){
        Select select = new Select(sortDropdown);
        select.selectByValue("price:desc");
    }
    public void selectValueReferenceHighestFirst(){
        Select select = new Select(sortDropdown);
        select.selectByValue("reference:desc");
    }




}
