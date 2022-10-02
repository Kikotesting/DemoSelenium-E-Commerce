package womenMenu;

import baseTest.BaseTest;
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

       homePage.menuWomen.click();

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
    @Order(3)
    @DisplayName("User can choose product by price Slider")
    void chooseItemWithSliderFilterByPrice_TC3() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftSlider_header, 5);
        womenPage.scrollToElement(womenPage.leftSlider_header);

        // Set slider to certain value
        womenPage.setSliderValueL("$17.85 - $53.00");

        // Check enabled filter by slider
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        System.out.println("Filters are set: "+ womenPage.enabledFilters.getText());
        womenPage.pauseSeconds(2);

        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 5 of 5 items");
        Assertions.assertEquals("Showing 1 - 5 of 5 items",womenPage.showingResults.getText());
    }
    @Test
    @Order(4)
    @DisplayName("User can add one filter from categories -> 'Dresses'")
    void markOneFilterFromCategories_TC4() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftHeader_breadcrumbTitle, 5);
        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,5);
        // Mark filter 'Dresses'
        womenPage.clickFilterDresses();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        womenPage.getListElements(womenPage.enabledFiltersList);
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());
        womenPage.pauseSeconds(2);
        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 5 of 5 items");
        Assertions.assertEquals("Showing 1 - 5 of 5 items",womenPage.showingResults.getText());
    }
    @Test
    @Order(4)
    @DisplayName("User can add more than one filter 'Dresses' and 'Polyester'")
    void markMoreThanOneFilterFromCatalogue_TC5() throws InterruptedException {
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftHeader_breadcrumbTitle, 5);
        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,5);

        // Mark filter 'Dresses'
        womenPage.clickFilterDresses();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        womenPage.getListElements(womenPage.enabledFiltersList);
        // Print which filters are set
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());
        womenPage.pauseSeconds(2);
        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 5 of 5 items");
        Assertions.assertEquals("Showing 1 - 5 of 5 items",womenPage.showingResults.getText());

        // Mark filter 'Polyester'
        womenPage.clickFilterPolyester();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        // Wait to refresh the text results after adding more filters
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 2 of 2 items");
        Assertions.assertEquals("Showing 1 - 2 of 2 items",womenPage.showingResults.getText());
        // Print which filters are set
        womenPage.getListElements(womenPage.enabledFiltersList);
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());
        womenPage.pauseSeconds(2);
    }
    @Test
    @Order(5)
    @DisplayName("User can remove added filter")
    void chooseOneFilterAndRemoveIt_TC6(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftHeader_breadcrumbTitle, 5);
        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,5);
        // Mark filter 'Dresses'
        womenPage.clickFilterDresses();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        womenPage.getListElements(womenPage.enabledFiltersList);
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());
        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 5 of 5 items");
        Assertions.assertEquals("Showing 1 - 5 of 5 items",womenPage.showingResults.getText());
        // Remove the filter
        womenPage.removeFilter.click();
        System.out.println("The filter is removed!");
        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 7 of 7 items");
        Assertions.assertEquals("Showing 1 - 7 of 7 items",womenPage.showingResults.getText());
    }
    @Test
    @Order(5)
    @DisplayName("User can remove more than one added filter")
    void chooseMoreFiltersAndRemoveIt(){
        homePage = new HomePage(driver);
        womenPage = new WomenPage(driver);

        homePage.menuWomen.click();
        womenPage.waitToBeVisible(womenPage.leftHeader_breadcrumbTitle, 5);
        womenPage.scrollToElement(womenPage.leftHeader_breadcrumbTitle);
        womenPage.waitToBeVisible(womenPage.showingResults,5);

        // Mark filter 'Dresses'
        womenPage.clickFilterDresses();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        womenPage.getListElements(womenPage.enabledFiltersList);
        // Print which filters are set
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());
        // Wait to refresh the text results after adding filter
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 5 of 5 items");
        Assertions.assertEquals("Showing 1 - 5 of 5 items",womenPage.showingResults.getText());

        // Mark filter 'Polyester'
        womenPage.clickFilterPolyester();
        // Check enabled filter
        womenPage.waitToBeVisible(womenPage.enabledFilters, 40);
        // Wait to refresh the text results after adding more filters
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 2 of 2 items");
        Assertions.assertEquals("Showing 1 - 2 of 2 items",womenPage.showingResults.getText());
        // Print which filters are set
        womenPage.getListElements(womenPage.enabledFiltersList);
        System.out.println("Filters are set: "+ womenPage.enabledFiltersList.getText());

        //Remove filters
        womenPage.removeFilter.click();
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 2 of 2 items");
        Assertions.assertEquals("Showing 1 - 2 of 2 items",womenPage.showingResults.getText());
        System.out.println("Removed again");

        womenPage.isElementDisplayed(womenPage.enabledFilters);
        womenPage.removeFilter.click();
        womenPage.waitRefreshedResultText(womenPage.showingResults, 40,"Showing 1 - 7 of 7 items");
        Assertions.assertEquals("Showing 1 - 7 of 7 items",womenPage.showingResults.getText());
        System.out.println("Removed again");
    }



}
