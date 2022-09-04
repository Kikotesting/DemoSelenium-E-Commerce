package homepage;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class HomePageTests extends BaseTest {

    HomePage homePage;




    @Test
    @DisplayName("CallUs number is displayed on leftHeader-Navbar")
    void verifyCallUsNumberIsDisplayed(){
        homePage = new HomePage(driver);
        String actualCallUsNumber = homePage.getTextFromElement(homePage.leftNavbarCallusNumber);

        Highlighter.highlightElement(driver,homePage.leftNavbarCallusNumber);
        Assertions.assertTrue(actualCallUsNumber.
                contains("Call us now: 0123-456-789"),
                "Message is not correct!");
    }

    @Test
    @DisplayName("User can browse the banners with Next and Prev buttons")
    void userCanBrowseBannersWithArrows(){
        homePage = new HomePage(driver);
        homePage.clickBannerArrowNext();
        homePage.clickBannerArrowNext();
        homePage.clickBannerArrowNext();
        homePage.waitSeconds(3);
        homePage.clickBannerArrowPrev();
        homePage.clickBannerArrowPrev();
        homePage.clickBannerArrowPrev();
    }

    @Test
    @DisplayName("Search is functional and generating the correct result")
    void searchWithValidStocksData(){

        homePage = new HomePage(driver);
        homePage.clickSearchBoxAndType("Summer dress");
        homePage.submitSearch();
        homePage.waitToBeVisible(homePage.summerDressResult, 5);
        homePage.waitToBeVisible(homePage.headingCounterResults, 5);

        Assertions.assertTrue(homePage.getTextFromElement(homePage.headingCounterResults)
                .contains("have been found"),
                "Result is different!");
    }
    @Test
    @DisplayName("Verify cart container is empty until user doesn't add anything")
    void verifyCartContainerIsEmpty(){
        homePage = new HomePage(driver);
        homePage.clickCartButton();
        homePage.waitToBeVisible(homePage.cartEmptyMessage, 3);
        Assertions.assertEquals("Your shopping cart is empty.",homePage.getTextFromElement(homePage.cartEmptyMessage));
    }

    @Test
    @DisplayName("Validates dropdown filter by Highest price and Reference Highest price")
    void performDropdownFilter() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickSearchBoxAndType("Dress");
        homePage.submitSearch();
        scrollToElement(homePage.sortDropdown);
        Highlighter.highlightElement(driver, homePage.sortDropdown);
        homePage.clickSortDropdown();
        homePage.selectValueHighestFirst();
        homePage.waitSeconds(3);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productOne)
                        .contains("Printed Dress")
                ,"Not correct!");
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productTwo)
                        .contains("Summer Dress")
                ,"Not correct!");
        homePage.clickSortDropdown();
        Highlighter.highlightElement(driver, homePage.sortDropdown);
        homePage.selectValueReferenceHighestFirst();
        homePage.waitSeconds(3);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productOne)
                        .contains("Printed Chiffon Dress")
                ,"Not correct!");
    }

    @Test
    @DisplayName("Hover functionality - All menus and links")
    void performHoverEffect(){
        homePage = new HomePage(driver);
        homePage.mainMenuWomen.click();

/*        hoverElement(homePage.mainMenuTshirts);
        Highlighter.highlightElement(driver, homePage.mainMenuTshirts);
        hoverElement(homePage.mainMenuWomen);
        Highlighter.highlightElement(driver, homePage.mainMenuWomen);
        hoverElement(homePage.mainMenuDresses);
        Highlighter.highlightElement(driver, homePage.mainMenuDresses);*/
    }






}
