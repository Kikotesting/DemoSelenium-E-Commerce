package dashboard;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.jupiter.api.*;

import pages.HomePage;
import pages.ShoppingCartPage;

public class HomePageTests extends BaseTest {

    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

/*

    @Test
    @Order(8)
    @DisplayName("Verify user can add product in shopping cart")
    void verifyAddProductInShoppingCart(){
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        homePage.waitToBeVisible(homePage.firstProduct, 2);
        hoverElement(homePage.firstProduct);
        homePage.waitToBeVisible(homePage.addToCart_FirstProduct, 2);
        homePage.clickElement(homePage.addToCart_FirstProduct);
        homePage.waitToBeVisible(homePage.alertAddProduct, 5);
        driver.switchTo().activeElement();
        String actualAddText = homePage.getTextFromElement(homePage.successAddProductText);
        Assertions.assertEquals("Product successfully added to your shopping cart", actualAddText);
        homePage.clickElement(homePage.processToCheckOut);
        String actualProductText = shoppingCartPage.getTextFromElement(shoppingCartPage.Description);
        String actualProductPageHeader = shoppingCartPage.getTextFromElement(shoppingCartPage.yourShoppingCart);
        Assertions.assertEquals("Your shopping cart", actualProductPageHeader);
        scrollToElement(shoppingCartPage.Summary);
        Assertions.assertEquals("Faded Short Sleeve T-shirts", actualProductText);
        shoppingCartPage.clickContinueShopping();
    }
    @Test
    @Order(9)
    @DisplayName("Verify user can add product in shopping cart and remove it")
    void verifyAddProductInShoppingCartAndRemove(){
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        homePage.waitToBeVisible(homePage.firstProduct, 2);
        hoverElement(homePage.firstProduct);
        homePage.waitToBeVisible(homePage.addToCart_FirstProduct, 2);
        homePage.clickElement(homePage.addToCart_FirstProduct);
        homePage.waitToBeVisible(homePage.alertAddProduct, 5);
        driver.switchTo().activeElement();
        String actualAddText = homePage.getTextFromElement(homePage.successAddProductText);
        Assertions.assertEquals("Product successfully added to your shopping cart", actualAddText);
        homePage.clickElement(homePage.processToCheckOut);
        String actualProductPageHeader = shoppingCartPage.getTextFromElement(shoppingCartPage.yourShoppingCart);
        Assertions.assertEquals("Your shopping cart", actualProductPageHeader);
        scrollToElement(shoppingCartPage.Summary);
        shoppingCartPage.clickRemoveProduct();
        homePage.waitToBeVisible(shoppingCartPage.cartEmptyMessage, 5);
        Assertions.assertEquals("Your shopping cart is empty.",homePage.getTextFromElement(shoppingCartPage.cartEmptyMessage));

    }*/


    @Test
    @Order(1)
    @DisplayName("Search valid stocks data in searchBox field")
    void searchWithValidData_TC1(){
        homePage = new HomePage(driver);

        homePage.setTextToField(homePage.searchBox,"DRESSES");
        homePage.submitSearchText_btn();
        homePage.waitToBeVisible(homePage.lighterSearchWord, 5);
        homePage.waitToBeVisible(homePage.counterSearchResults, 5);

        Assertions.assertTrue(homePage.getTextFromElement(homePage.lighterSearchWord)
                        .contains("DRESSES"),
                "Result is different!");
        Assertions.assertTrue(homePage.getTextFromElement(homePage.counterSearchResults)
                        .contains("7 results have been found."),
                "Result is different!");
    }
    @Test
    @Order(1)
    @DisplayName("Search invalid stocks data in searchBox field")
    void searchWithInvalidData_TC2(){
        homePage = new HomePage(driver);

        homePage.setTextToField(homePage.searchBox,"gudsgsdghs");
        homePage.submitSearchText_btn();
        homePage.waitToBeVisible(homePage.incorrectResults, 5);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.incorrectResults)
                        .contains("No results were found for your search"),
                "Result is different!");
    }
    @Test
    @Order(2)
    @DisplayName("Subscribe your mail for newsletters")
    void subscribeYourEmailForNewsLetters_TC3(){
        homePage = new HomePage(driver);
        // Go to the end on webPage
        homePage.scrollEndPage();
        // Change the email for new user
        homePage.setTextToField(homePage.newsLetterInput, "newhdfhdfh24@mail.bg");
        homePage.submitNewsLetter_btn();
        homePage.waitToBeVisible(homePage.newsLetterMessage, 5);
        String newUser = "Newsletter : You have successfully subscribed to this newsletter.";
        Assertions.assertEquals(newUser,homePage.newsLetterMessage.getText(),"Wrong text!");

        String registeredUser = "Newsletter : This email address is already registered.";
        Assertions.assertEquals(registeredUser,homePage.newsLetterMessage.getText(),"Wrong text!");
    }
    @Test
    @Order(2)
    @DisplayName("Cannot subscribe exist email for newsletters")
    void cannotSubscribeExistEmail_TC4(){
        homePage = new HomePage(driver);
        // Go to the end on webPage
        homePage.scrollEndPage();
        homePage.setTextToField(homePage.newsLetterInput, "mislead@mail.bg");
        homePage.submitNewsLetter_btn();
        homePage.waitToBeVisible(homePage.newsLetterMessage, 5);
        String registeredUser = "Newsletter : This email address is already registered.";
        Assertions.assertEquals(registeredUser,homePage.newsLetterMessage.getText(),"Wrong text!");
    }
    @Test
    @Order(3)
    @DisplayName("User can browse the banners with Next and Prev buttons")
    void userCanBrowseBannersWithButtons_TC5(){
        homePage = new HomePage(driver);
        homePage.scrollToElement(homePage.bannerContainer);
        //Pause seconds are set for UI testing purpose when check the test!
        homePage.clickBannerArrowNext();
        homePage.pauseSeconds(1);
        homePage.clickBannerArrowPrev();
        homePage.pauseSeconds(1);
        homePage.clickBannerArrowNext();
        homePage.pauseSeconds(1);
        homePage.clickBannerArrowNext();
        // Assertions should be set about wich picture is on the screen
    }
    @Test
    @Order(4)
    @DisplayName("Verify cart container is empty until user doesn't add items")
    void verifyShoppingCartIsEmpty_TC6(){
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        homePage.clickCartButton();
        shoppingCartPage.waitToBeVisible(shoppingCartPage.cartEmptyMessage, 3);
        Assertions.assertEquals("Your shopping cart is empty.",homePage.getTextFromElement(shoppingCartPage.cartEmptyMessage));
    }

    @Test
    @Order(5)
    @DisplayName("Validates dropdown filter from A to Z ordered Items")
    void performDropdownFilter(){
        homePage = new HomePage(driver);

        // Start searching products
        homePage.setTextToField(homePage.searchBox, "Dresses");
        homePage.submitSearchText_btn();
        // Scroll to dropdown filter
        homePage.scrollToElement(homePage.sortDropdown);
        Highlighter.highlightElement(driver, homePage.sortDropdown);
        homePage.selectElement(homePage.sortDropdown);
        homePage.selectByValueElement(homePage.sortDropdown, "name:asc");
        homePage.list_btn.click();
        homePage.waitToBeVisible(homePage.productA_Z_Blouse, 10);
        homePage.waitToBeVisible(homePage.productA_Z_FadedShortSleeve, 10);
        homePage.getListElements(homePage.listA_Z_allItems);
        Assertions.assertEquals(homePage.productA_Z_FirstElement.getText(),"Blouse");
        Assertions.assertEquals(homePage.productA_Z_SecondElement.getText(),"\n" +
                "\t\t\t\t\t\t\tFaded Short Sleeve T-shirts\n" +
                "\t\t\t\t\t\t");
    }
}
