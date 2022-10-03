package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }



    //Main menus
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a") public WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") public WebElement menuDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a") public WebElement menuTshirts;

    //Return to homepage
    @FindBy(className = "logo img-responsive") public WebElement backButtonHome;

    //Cart button
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a") public WebElement cartButton;

    /**
     * SEARCH elements
     */
    @FindBy(name = "search_query") public WebElement searchBox;
    @FindBy(name = "submit_search") WebElement submitSearchButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]") public WebElement lighterSearchWord;
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[2]") public WebElement counterSearchResults;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p") public WebElement incorrectResults;

    /**
     * ACCOUNT navigation
     */
    @FindBy(className = "login") public WebElement signIn_btn;
    @FindBy(linkText = "Contact us") public WebElement contactUs_btn;

    //Nav banner according
    @FindBy(xpath = "//*[@id=\"columns\"]") public WebElement bannerContainer;
    @FindBy(className = "bx-next") public WebElement bannerNext;
    @FindBy(className = "bx-prev") public WebElement bannerPrev;

    //Filters
    @FindBy(className = "blockbestsellers") public WebElement filterButtonBestSellers;
    @FindBy(className = "homefeatured") public WebElement filterButtonPopular;


    // Sort by Highest Price then Reference Highest
    @FindBy(xpath = "//*[@id=\"grid\"]/a/i") public WebElement  grid_btn;
    @FindBy(xpath = "//*[@id=\"list\"]/a/i") public WebElement list_btn;
    @FindBy(id = "selectProductSort") public WebElement sortDropdown;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]") public WebElement productA_Z_Blouse;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div/div[2]/h5/a") public WebElement productA_Z_FirstElement;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]") public WebElement productA_Z_FadedShortSleeve;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div/div[2]/h5/a") public WebElement productA_Z_SecondElement;
    @FindBy(xpath = "//*[@class='product_list row list']") public WebElement listA_Z_allItems;


    @FindBy(id = "cmsinfo_block") public WebElement cmsInfoBlock;
    @FindBy(className = "footer-container") public WebElement footerContainer;

    /**
     * Social footer icons
     */
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[1]") public WebElement facebook;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[2]") public WebElement twitter;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[3]") public WebElement youtube;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[4]") public WebElement google_plus;


    /**
     * Newsletter elements
     **/
    @FindBy(id = "newsletter-input") public WebElement newsLetterInput;
    @FindBy(name = "submitNewsletter") public WebElement submitNewLetter_btn;
    @FindBy(xpath = "//*[@id=\"columns\"]/p") public WebElement newsLetterMessage;

    public void submitSearchText_btn(){
        isElementDisplayed(submitSearchButton);
        submitSearchButton.click();
    }
    public void clickSignInButton(){
        isElementDisplayed(signIn_btn);
        signIn_btn.click();
    }
    public void submitNewsLetter_btn(){
        isElementDisplayed(submitNewLetter_btn);
        submitNewLetter_btn.click();
    }

    public void clickBannerArrowNext(){
        isElementDisplayed(bannerNext);
        bannerNext.click();
    }
    public void clickBannerArrowPrev(){
        isElementDisplayed(bannerPrev);
        bannerPrev.click();
    }
    public void clickCartButton(){
        isElementDisplayed(cartButton);
        cartButton.click();
    }



}
