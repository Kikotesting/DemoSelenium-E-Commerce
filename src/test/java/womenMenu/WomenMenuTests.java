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



*/

    @Test
    @Order(1)
    @DisplayName("Submenus dropdown effects in WomenMENU")
    void clickSubmenusDropdown_TC1(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();

        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        womenPage.submenu_Tops.click();
        womenPage.waitToBeVisible(womenPage.submenu_Tops_Blouses, 5);
        womenPage.hoverElement(womenPage.submenu_Tops_Blouses);
        womenPage.pauseSeconds(1);
        womenPage.waitToBeVisible(womenPage.submenu_Tops_Tshirts, 5);
        womenPage.hoverElement(womenPage.submenu_Tops_Tshirts);
        womenPage.pauseSeconds(1);
        womenPage.submenu_Dresses.click();
        womenPage.waitToBeVisible(womenPage.submenu_Dresses_Casual, 5);
        womenPage.hoverElement(womenPage.submenu_Dresses_Casual);
        womenPage.pauseSeconds(1);
        womenPage.waitToBeVisible(womenPage.submenu_Dresses_Evening, 5);
        womenPage.hoverElement(womenPage.submenu_Dresses_Evening);
        womenPage.pauseSeconds(1);
        womenPage.waitToBeVisible(womenPage.submenu_Dresses_Summer, 5);
        womenPage.hoverElement(womenPage.submenu_Dresses_Summer);
        womenPage.pauseSeconds(1);
    }
    @Test
    @Order(2)
    @DisplayName("User can change typeViews (Grid and List) and hover the elements")
    void changeTypeViewsAndHoverElements_TC2(){
       homePage = new HomePage(driver);
       womenPage = new WomenPage(driver);

       homePage.clickElementJavascript(homePage.menuWomen);

       womenPage.waitToBeVisible(womenPage.leftHeader_breadcrumbTitle, 10);
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

    @Test
    @Order(5)
    @DisplayName("User can choose product by price Slider")
    void chooseItemWithSliderFilter_byPrice() {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftSlider_header, 5);
        womenPage.scrollToElement(womenPage.leftSlider_header);
        // Waiting for slider to be clickable
        womenPage.waitToBeClickable(womenPage.leftSlider_priceL, 3);
        // Set slider to certain value
        womenPage.setSliderValue(40);
        womenPage.pauseSeconds(5);
        // Verify showing result
        womenPage.waitToRefreshElement(womenPage.showingResults,50,"Showing 1 - 2 of 2 items");
    }

}
