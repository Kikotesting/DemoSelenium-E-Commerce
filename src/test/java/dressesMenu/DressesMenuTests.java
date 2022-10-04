package dressesMenu;

import baseTest.BaseTest;
import custom.Highlighter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.*;

public class DressesMenuTests extends BaseTest {

    HomePage homePage;
    ShoppingCartPage shopCartPage;
    DressesPage dressPage;
    AlertPage alertPage;
    AuthenticationPage authPage;
    AccountPage accPage;
    ProductPage productPage;

    public void defaultLogin(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);
        //Sing in with valid credentials
        homePage.signIn_btn.click();
        authPage.setRegisteredMail("mislead@mail.bg");
        authPage.setRegisteredPass("Kiko123@");
        authPage.clickSignInButton();
        accPage.waitToBeVisible(accPage.welcomeMessage,10);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accPage.getTextFromElement(accPage.welcomeMessage));
    }
    @Test
    @Order(1)
    @DisplayName("Verify user can add product in shopping cart")
    void verifyAddProductInShoppingCart_TC1(){
        homePage = new HomePage(driver);
        dressPage = new DressesPage(driver);
        shopCartPage = new ShoppingCartPage(driver);
        alertPage = new AlertPage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        //Sing in with valid credentials
        defaultLogin();

        // Go to Dress menu
        homePage.menuDresses.click();
        dressPage.scrollToElement(dressPage.subcategoriesMenu_Header);
        //Mark cotton filter, and one product left on the page
        dressPage.cottonFilter.click();
        dressPage.waitToBeVisible(dressPage.showingResults, 10);
        dressPage.waitToBeVisible(dressPage.enabledFilters, 30);
        dressPage.getListElements(dressPage.enabledFiltersList);
        System.out.println("Filters are set: "+ dressPage.enabledFiltersList.getText());
        dressPage.waitRefreshedResultText(dressPage.showingResults, 40,"Showing 1 - 1 of 1 items");
        Assertions.assertEquals("Showing 1 - 1 of 1 items",dressPage.showingResults.getText());
        // Add to shopping cart
        dressPage.list_btn.click();
        dressPage.waitToBeVisible(dressPage.addCart_btn_PrintedDress,10);
        dressPage.addCart_btn_PrintedDress.click();

        // Wait to be visible alert page for adding product
        alertPage.waitToBeVisible(alertPage.addingProduct_layer, 10);
        driver.switchTo().activeElement();
        // Check the product is added and wait proceed checkout
        String actualAddTextOne = alertPage.getTextFromElement(alertPage.headerOne_SuccessAddProduct);
        Assertions.assertEquals("Product successfully added to your shopping cart", actualAddTextOne);
        String actualAddTextTwo = alertPage.getTextFromElement(alertPage.headerTwo_SuccessAddProduct);
        Assertions.assertEquals("There is 1 item in your cart.", actualAddTextTwo);

        // Go to Shopping cart page
        alertPage.proceed_btn.click();
        shopCartPage.waitToBeVisible(shopCartPage.tableWith_product,10);
        shopCartPage.scrollToElement(shopCartPage.tableWith_product);
        shopCartPage.checkout_btn_summary.click();
        // Go to Address
        shopCartPage.waitToBeVisible(shopCartPage.yourDeliveryAddress,10);
        shopCartPage.waitToBeVisible(shopCartPage.billingAddress,10);
        shopCartPage.scrollToElement(shopCartPage.billingAddress);
        shopCartPage.checkout_btn_address.click();
        // Go to Shipping, agreed with terms
        shopCartPage.waitToBeVisible(shopCartPage.terms_shipping, 10);
        shopCartPage.scrollToElement(shopCartPage.terms_shipping);
        shopCartPage.terms_checkbox.click();
        shopCartPage.checkout_btn_shipping.click();
        // Go to Payment
        shopCartPage.waitToBeVisible(shopCartPage.description_Payment, 10);
        shopCartPage.scrollToElement(shopCartPage.totalPrice);
        Assertions.assertEquals("TOTAL",shopCartPage.totalText.getText());
        Assertions.assertEquals("$29.12",shopCartPage.totalPrice.getText());
        // Click Pay by check
        shopCartPage.checkout_btn_payByCheck.click();
        shopCartPage.waitToBeVisible(shopCartPage.importantMessage,10);
        shopCartPage.scrollToElement(shopCartPage.importantMessage);
        Assertions.assertEquals("You have chosen to pay by check. Here is a short summary of your order:",shopCartPage.importantMessage.getText());
        // Click confirm order
        shopCartPage.confirmOrder_btn.click();
        shopCartPage.waitToBeVisible(shopCartPage.completeMessage,20);
        shopCartPage.scrollToElement(shopCartPage.completeMessage);
        Assertions.assertEquals("Your order on My Store is complete.",shopCartPage.completeMessage.getText());
        // Click Back to Orders table
        shopCartPage.backToOrders_btn.click();
        shopCartPage.waitToBeVisible(shopCartPage.ordersTable_header, 10);
        shopCartPage.scrollToElement(shopCartPage.ordersTable_header);
        Assertions.assertEquals("ORDER HISTORY",shopCartPage.ordersTable_header.getText());
    }

    @Test
    @Order(2)
    @DisplayName("User can look the product by more details via More button")
    void exploreItemWithMoreButton(){
        homePage = new HomePage(driver);
        dressPage = new DressesPage(driver);
        productPage = new ProductPage(driver);

        //login
        defaultLogin();
        homePage.menuDresses.click();
        // scroll to element
        homePage.list_btn.click();
        dressPage.scrollToElement(dressPage.item_PrintedChiffonDress);
        dressPage.more_btn_PrintedChiffon.click();
        // scroll to product view and check the text and price
        productPage.scrollToElement(productPage.productPage_breadcrumb);
        String actualProductHeader = "Printed Chiffon Dress";
        Highlighter.highlightElement(driver,productPage.productHeader);
        Assertions.assertEquals(productPage.productHeader.getText(),actualProductHeader);
        String actualProductPrice = "$16.40";
        Highlighter.highlightElement(driver,productPage.productPrice);
        Assertions.assertEquals(productPage.productPrice.getText(),actualProductPrice);
        // Select color and M size
        productPage.selectByIndexElement(productPage.productSize_dropdown, 1);
        Highlighter.highlightElement(driver,productPage.productSize_dropdown);
        productPage.pauseSeconds(2);
        productPage.productColor_green.click();
        productPage.pauseSeconds(2);
        //Click zoom view
        productPage.productZoom_btn.click();
        driver.switchTo().activeElement();
        productPage.pauseSeconds(2);
        // Close the zoom view
        productPage.productZoom_btnClose.click();
        productPage.pauseSeconds(2);
    }





}
