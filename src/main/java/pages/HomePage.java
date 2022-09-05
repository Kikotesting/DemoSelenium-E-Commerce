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
    @FindBy(xpath = "//*[@id=\"columns\"]") public WebElement bannerContainer;

    //Main menu
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a") public WebElement mainMenuWomen;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") public WebElement mainMenuDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a") public WebElement mainMenuTshirts;

    //Return to homepage
    @FindBy(className = "logo img-responsive") public WebElement backButtonHome;

    //Cart button
    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a") public WebElement cartButton;

    //Searchbox
    @FindBy(name = "search_query") public WebElement searchBox;
    @FindBy(name = "submit_search") WebElement submitSearchButton;
    @FindBy(className = "lighter") public WebElement summerDressResult;
    @FindBy(className = "heading-counter") public WebElement headingCounterResults;
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
    @FindBy(id = "newsletter-input") public WebElement newLetter;
    @FindBy(name = "submitNewsletter") public WebElement submitNewLetterBtn;
    @FindBy(name = "submitNewsletter") public WebElement newsLetterMessage;
    @FindBy(xpath = "//*[@id=\"columns\"]/p") public WebElement existNewsLetterMessage;



    //Click Elements
    public void clickElement(WebElement elementMenu){
        isElementDisplayed(elementMenu);
        elementMenu.click();
    }

    public void populateNewsLetterField(String mail){
        isElementDisplayed(newLetter);
        newLetter.clear();
        newLetter.sendKeys(mail);
    }
    public void clickNewsLetterField(){
        submitNewLetterBtn.click();
    }
    public void clickSignInButton(){
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
