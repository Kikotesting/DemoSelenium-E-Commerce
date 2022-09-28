package dashboard;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.jupiter.api.*;

import pages.HomePage;
import pages.ShoppingCartPage;

public class HomePageTests extends BaseTest {

    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

/*    @Test
    @Order(1)
    @DisplayName("Hover functionality - Main menus, ContactUs, SignIn, Popular, BestSellers, Products, Custom block, Footer social medias")
    void performHoverEffect(){
        homePage = new HomePage(driver);

        hoverElement(homePage.signInButton);
        Highlighter.highlightElement(driver, homePage.signInButton);
        hoverElement(homePage.navRightContactUs);
        Highlighter.highlightElement(driver, homePage.navRightContactUs);

        scrollToElement(homePage.mainMenuTshirts);
        hoverElement(homePage.mainMenuTshirts);
        Highlighter.highlightElement(driver, homePage.mainMenuTshirts);
        hoverElement(homePage.mainMenuWomen);
        Highlighter.highlightElement(driver, homePage.mainMenuWomen);
        hoverElement(homePage.mainMenuDresses);
        Highlighter.highlightElement(driver, homePage.mainMenuDresses);

        scrollToElement(homePage.filterButtonBestSellers);
        hoverElement(homePage.filterButtonBestSellers);
        Highlighter.highlightElement(driver, homePage.filterButtonBestSellers);
        hoverElement(homePage.filterButtonPopular);
        Highlighter.highlightElement(driver, homePage.filterButtonPopular);

        scrollToElement(homePage.firstProduct);
        hoverElement(homePage.firstProduct);
        hoverElement(homePage.secondProduct);
        hoverElement(homePage.thirdProduct);
        hoverElement(homePage.fourthProduct);

        scrollToElement(homePage.fifthProduct);
        hoverElement(homePage.fifthProduct);
        hoverElement(homePage.sixthProduct);
        hoverElement(homePage.seventhProduct);

        scrollToElement(homePage.cmsInfoBlock);
        hoverElement(homePage.cmsInfoBlock);
        Highlighter.highlightElement(driver, homePage.cmsInfoBlock);

        scrollToElement(homePage.footerContainer);
        hoverElement(homePage.facebook);
        hoverElement(homePage.twitter);
        hoverElement(homePage.youtube);
        hoverElement(homePage.google_plus);
    }
    @Test
    @Order(2)
    @DisplayName("CallUs number is Visible on leftHeader-Navbar")
    void verifyCallUsNumberIsDisplayed(){
        homePage = new HomePage(driver);
        String actualCallUsNumber = homePage.getTextFromElement(homePage.leftNavbarCallusNumber);

        Highlighter.highlightElement(driver,homePage.leftNavbarCallusNumber);
        Assertions.assertTrue(actualCallUsNumber.
                        contains("Call us now: 0123-456-789"),
                "Message is not correct!");
    }
    @Test
    @Order(4)
    @DisplayName("Search functionality - no result with invalid data")
    void searchWithInvalidData(){

        homePage = new HomePage(driver);
        homePage.clickSearchBoxAndType("guhs");
        homePage.submitSearch();
        homePage.waitToBeVisible(homePage.incorrectResults, 5);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.incorrectResults)
                        .contains("No results were found for your search"),
                "Result is different!");
    }
    @Test
    @Order(5)
    @DisplayName("User can browse the banners with Next and Prev buttons")
    void userCanBrowseBannersWithArrows() throws InterruptedException {
        homePage = new HomePage(driver);
        scrollToElement(homePage.bannerContainer);
        homePage.clickBannerArrowNext();
        //Thread sleep is set for UI testing purpose when check the test!
        Thread.sleep(1000);
        homePage.clickBannerArrowPrev();
        Thread.sleep(1000);
        homePage.clickBannerArrowNext();
        Thread.sleep(1000);
        homePage.clickBannerArrowNext();
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
        homePage.pauseSeconds(3);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productOne)
                        .contains("Printed Dress")
                ,"Not correct!");
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productTwo)
                        .contains("Summer Dress")
                ,"Not correct!");
        homePage.clickSortDropdown();
        Highlighter.highlightElement(driver, homePage.sortDropdown);
        homePage.selectValueReferenceHighestFirst();
        homePage.pauseSeconds(3);
        Assertions.assertTrue(homePage.getTextFromElement(homePage.productOne)
                        .contains("Printed Chiffon Dress")
                ,"Not correct!");
    }
    @Test
    @Order(7)
    @DisplayName("Verify cart container is empty until user doesn't add anything")
    void verifyShoppingCartIsEmpty(){
        homePage = new HomePage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        homePage.clickCartButton();
        shoppingCartPage.waitToBeVisible(shoppingCartPage.cartEmptyMessage, 3);
        Assertions.assertEquals("Your shopping cart is empty.",homePage.getTextFromElement(shoppingCartPage.cartEmptyMessage));
    }
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
    void searchWithValidStocksData_TC1(){
        homePage = new HomePage(driver);

        homePage.setTextToField(homePage.searchBox,"dresses");
        homePage.submitSearchText_btn();
        homePage.waitToBeVisible(homePage.lighterSearchWord, 5);
        homePage.waitToBeVisible(homePage.counterSearchResults, 5);
        homePage.scrollToElement(homePage.lighterSearchWord);

        Assertions.assertTrue(homePage.getTextFromElement(homePage.lighterSearchWord)
                        .contains("DRESSES"),
                "Result is different!");
        Assertions.assertTrue(homePage.getTextFromElement(homePage.counterSearchResults)
                        .contains("7 results have been found."),
                "Result is different!");
    }
    @Test
    @Order(2)
    @DisplayName("Subscribe your mail for newsletters")
    void subscribeYourEmailForNewsLetters_TC2(){
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
    void cannotSubscribeExistEmail_TC3(){
        homePage = new HomePage(driver);
        // Go to the end on webPage
        homePage.scrollEndPage();
        // Second time when the test is executed will see the 'else' decision from the if-else element
        homePage.setTextToField(homePage.newsLetterInput, "mislead@mail.bg");
        homePage.submitNewsLetter_btn();
        homePage.waitToBeVisible(homePage.newsLetterMessage, 5);
        String registeredUser = "Newsletter : This email address is already registered.";
        Assertions.assertEquals(registeredUser,homePage.newsLetterMessage.getText(),"Wrong text!");
    }
}
