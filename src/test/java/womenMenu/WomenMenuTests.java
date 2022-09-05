package womenMenu;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.WomenPage;

public class WomenMenuTests extends BaseTest {
    HomePage homePage;
    WomenPage womenPage;

    @Test
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
        waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 5 of 5 items");
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
        waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        scrollToElement(womenPage.womenRightBlockTitle);
        womenPage.waitToBeVisible(womenPage.enabledFilters,4);
        womenPage.clickRemoveFilter();
        waitRefreshedResultText(5, womenPage.showingResults,"Showing 1 - 7 of 7 items");
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
        waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 5 of 5 items");
        womenPage.clickFilterBlackColor();
        waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 1 of 1 items");
        womenPage.waitToBeVisible(womenPage.enabledFilters,4);
        womenPage.clickRemoveFilter(); // remove first filter
        waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 2 of 2 items");
        womenPage.clickRemoveFilter(); // remove second filter
        waitRefreshedResultText(10, womenPage.showingResults,"Showing 1 - 7 of 7 items");
        Assertions.assertTrue(womenPage.getTextFromElement(womenPage.showingResults)
                .contains("Showing 1 - 7 of 7 items"),"Does not removed");
    }

    @Test
    @Order(4)
    @DisplayName("User can change typeViews on WomenPage")
    void changeTypeViews(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);
        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.womenRightBlockTitle, 2);
        scrollToElement(womenPage.viewTypes);
        womenPage.clickListView();
        hoverElement(womenPage.firstProductListView);
        Highlighter.highlightElement(driver,womenPage.firstProductListView);
        womenPage.clickGridView();
        hoverElement(womenPage.firstProductGridView);
        Highlighter.highlightElement(driver,womenPage.firstProductGridView);

    }

    @Test
    @Order(5)
    @DisplayName("User can choose product by price Slider")
    void sliderFilterByPrice(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.clickElement(homePage.mainMenuWomen);
        womenPage.waitToBeVisible(womenPage.filterheaderPrice, 2);
        scrollToElement(womenPage.filterheaderPrice);
        String value = "$40 - $53.00";
        womenPage.setSliderValue(value);
        //waitRefreshedResultText(5,womenPage.priceRange,value);
        Assertions.assertEquals("$40 - $53.00",womenPage.getSliderValue());
    }

}
