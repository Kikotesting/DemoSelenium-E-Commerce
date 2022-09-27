package womenMenu;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import pages.HomePage;
import pages.WomenPage;

public class WomenMenuTests extends BaseTest {
    HomePage homePage;
    WomenPage womenPage;

   /* @Test
    @Order(1)
    @DisplayName("User can enable Filter and expect specific result")
    void selectFiltersForSpecificResult() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.womenRightBlockTitle, 2);

        scrollToElement(womenPage.womenRightBlockTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,3);
        String actualText = womenPage.getTextFromElement(womenPage.showingResults);
        Assertions.assertTrue(actualText
                .contains("Showing 1 - 7 of 7 items"),"Is not displayed all items!");
        womenPage.clickFilterDresses();
        womenPage.waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        scrollToElement(womenPage.showingResults);
        Assertions.assertTrue(womenPage.getTextFromElement(womenPage.showingResults)
                .contains("Showing 1 - 5 of 5 items"),"Is not displayed correct counter!");

    }

    @Test
    @Order(2)
    @DisplayName("User can remove Filter")
    void chooseOneFilterAndRemoveIt() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.womenRightBlockTitle, 2);
        scrollToElement(womenPage.womenRightBlockTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,3);
        String actualText = womenPage.getTextFromElement(womenPage.showingResults);
        Assertions.assertTrue(actualText
                .contains("Showing 1 - 7 of 7 items"),"Is not displayed all items!");
        womenPage.clickFilterDresses();
        womenPage.waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        scrollToElement(womenPage.womenRightBlockTitle);
        womenPage.waitToBeVisible(womenPage.enabledFilters,4);
        womenPage.clickRemoveFilter();
        womenPage.waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 7 of 7 items");
        Assertions.assertTrue(womenPage.getTextFromElement(womenPage.showingResults)
                .contains("Showing 1 - 7 of 7 items"),"Does not removed");

    }

    @Test
    @Order(3)
    @DisplayName("User can remove more than one Filter")
    void chooseMoreFiltersAndRemoveIt() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.womenRightBlockTitle, 2);
        scrollToElement(womenPage.womenRightBlockTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,3);
        String actualText = womenPage.getTextFromElement(womenPage.showingResults);
        Assertions.assertTrue(actualText
                .contains("Showing 1 - 7 of 7 items"),"Is not displayed all items!");
        womenPage.clickFilterDresses(); // first filter
        womenPage.waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        womenPage.clickFilterBlackColor();
        womenPage.waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 1 of 1 items");
        womenPage.waitToBeVisible(womenPage.enabledFilters,4);
        womenPage.clickRemoveFilter(); // remove first filter
        womenPage.waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 2 of 2 items");
        womenPage.clickRemoveFilter(); // remove second filter
        womenPage.waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 7 of 7 items");
        Assertions.assertTrue(womenPage.getTextFromElement(womenPage.showingResults)
                .contains("Showing 1 - 7 of 7 items"),"Does not removed");
    }

    @Test
    @Order(5)
    @DisplayName("User can choose product by price Slider")
    void sliderFilterByPrice() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.filterheaderPrice, 2);
        scrollToElement(womenPage.filterheaderPrice);
        womenPage.waitToBeClickable(womenPage.leftSliderPrice, 3);
        Assertions.assertTrue(womenPage.leftSliderPrice.isDisplayed());
        womenPage.setSliderValue("$30.80 - $53.00");
        womenPage.waitToBeVisible(womenPage.showingResults,10);
        womenPage.waitRefreshedResultText(15, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        scrollToElement(womenPage.showingResults);
        String actualResult = womenPage.getTextFromElement(womenPage.showingResults);
        Assertions.assertTrue(actualResult
                .contains("Showing 1 - 5 of 5 items"),"Is not displayed all items!");

    }

    @Test
    @Order(6)
    @DisplayName("Dropdown submenus effects")
    void clickSubDropdownMenus(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.submenu_DressesDropdown.click();
        womenPage.waitToBeVisible(womenPage.submenu_DressesDropdown_SummerDresses,3);
        womenPage.submenu_TopsDropdown.click();
        womenPage.waitToBeVisible(womenPage.submenu_TopsDropdown_Blouses,3);
    }*/
   @Test
   @Order(1)
   @DisplayName("User can change typeViews (Grid and List) and hover the elements")
   void changeTypeViewsAndHoverElement_TC1(){
       homePage = new HomePage(driver);
       womenPage = new WomenPage(driver);

       homePage.clickElementJavascript(homePage.mainMenuWomen);

       womenPage.waitToBeVisible(womenPage.leftHeader_BlockTitle, 10);
       womenPage.scrollToElement(womenPage.subCategories_div);
       womenPage.pauseSeconds(2);
       // List view and hover the elements
       womenPage.clickListViews();
       womenPage.scrollToElement(womenPage.product_FadedShortSleeve);
       womenPage.hoverElement(womenPage.product_FadedShortSleeve);
       womenPage.pauseSeconds(1);
       womenPage.scrollToElement(womenPage.product_Blouse);
       womenPage.hoverElement(womenPage.product_Blouse);
       womenPage.pauseSeconds(1);

       // Grid view and hover the elements
       womenPage.clickGridViews();
       womenPage.hoverElement(womenPage.product_FadedShortSleeve);
       womenPage.pauseSeconds(1);
       womenPage.hoverElement(womenPage.product_Blouse);
       womenPage.pauseSeconds(1);
       womenPage.hoverElement(womenPage.product_PrintedDress);
       womenPage.pauseSeconds(1);
   }

}
