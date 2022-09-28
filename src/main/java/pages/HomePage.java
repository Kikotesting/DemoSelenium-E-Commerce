package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/span") public WebElement leftNavbarCallusNumber;
    @FindBy(xpath = "//*[@id=\"columns\"]") public WebElement bannerContainer;

    //Main menu
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a") public WebElement menuWomen;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") public WebElement menuDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a") public WebElement menuTshirts;

    //Return to homepage
    @FindBy(className = "logo img-responsive") public WebElement backButtonHome;

    //Cart button
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a") public WebElement cartButton;

    //Searchbox
    @FindBy(name = "search_query") public WebElement searchBox;
    @FindBy(name = "submit_search") WebElement submitSearchButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]") public WebElement lighterSearchWord;
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[2]") public WebElement counterSearchResults;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p") public WebElement incorrectResults;

    //Account navigation
    @FindBy(className = "login") public WebElement signInButton;

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

    // Hover elements on dashboard page
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]") public WebElement firstProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span") public WebElement addToCart_FirstProduct;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]") public WebElement alertAddProduct;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2") public WebElement successAddProductText;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span") public WebElement processToCheckOut;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]") public WebElement secondProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[3]") public WebElement thirdProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[4]") public WebElement fourthProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[5]") public WebElement fifthProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[6]") public WebElement sixthProduct;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[7]") public WebElement seventhProduct;
    @FindBy(id = "cmsinfo_block") public WebElement cmsInfoBlock;
    @FindBy(className = "footer-container") public WebElement footerContainer;

    //Social icons
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[1]") public WebElement facebook;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[2]") public WebElement twitter;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[3]") public WebElement youtube;
    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[4]") public WebElement google_plus;


    //Newsletters
    @FindBy(id = "newsletter-input") public WebElement newsLetterInput;
    @FindBy(name = "submitNewsletter") public WebElement submitNewLetter_btn;
    @FindBy(xpath = "//*[@id=\"columns\"]/p") public WebElement newsLetterMessage;

    public void submitNewsLetter_btn(){
        submitNewLetter_btn.click();
    }
    public void clickSignInButton(){
        isElementDisplayed(signInButton);
        signInButton.click();
    }
    public void clickBannerArrowNext(){
        isElementDisplayed(bannerNext);
        bannerNext.click();
    }
    public void clickBannerArrowPrev(){
        isElementDisplayed(bannerPrev);
        bannerPrev.click();
    }
    public void submitSearchText_btn(){
        isElementDisplayed(submitSearchButton);
        submitSearchButton.click();
    }
    public void clickCartButton(){
        isElementDisplayed(cartButton);
        cartButton.click();
    }
}
