package account;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.AuthenticationPage;
import pages.HomePage;

public class AccountTests extends BaseTest {

    HomePage homePage;
    AuthenticationPage authPage;
    AccountPage accPage;

    @Test
    @Order(1)
    @DisplayName("Create an account with NEW Email")
    void CreateAnAccount(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.waitToBeVisible(authPage.emailAddressForCreateAccount_field,10);
        // Email can change for the next test (1)
        authPage.setInputText(authPage.emailAddressForCreateAccount_field,"kiko11211@mail.bg");
        authPage.clickCreateAccount_btn();
        // Wait to be visible account page for populating all fields
        accPage.waitToBeVisible(accPage.breadcrumbHeader,10);
        Assertions.assertEquals("Authentication",accPage.getTextFromElement(accPage.breadcrumbHeader));
        // Populate the first block elements
        accPage.scrollToElement(accPage.personalInformation);
        // Email can change for the next test (2)
        accPage.populatePersonalInfo("Kiko","Kikonev","kiko11211@mail.bg","Proba123@");
        // Populate the second block elements
        accPage.scrollToElement(accPage.personalAddress);
        // Email can change for the next test (3)
        accPage.populatePersonalAddress("Kikcho","Kikchov","Lozenets, Sofia 1000","Sofia","75201","0877227711","Kiko@p21.bg");
        // Click register button
        accPage.scrollToElement(accPage.register_btn);
        accPage.clickElementJavascript(accPage.register_btn);
        // Wait until welcome message for logged acc is displayed
        accPage.waitToBeVisible(accPage.welcomeMessage,10);
        accPage.scrollToElement(accPage.welcomeMessage);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accPage.getTextFromElement(accPage.welcomeMessage));
    }

    @Test
    @Order(2)
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidEmailAndPassword(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();

        authPage.setRegisteredMail("mislead@mail.bg");
        authPage.setRegisteredPass("Kiko123@");
        authPage.clickSignInButton();

        accPage.waitToBeVisible(accPage.welcomeMessage,10);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accPage.getTextFromElement(accPage.welcomeMessage));
    }

    @Test
    @Order(3)
    @DisplayName("User can login and logout")
    void userCanLoginWithAndLogout(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();

        authPage.setRegisteredMail("mislead@mail.bg");
        authPage.setRegisteredPass("Kiko123@");
        authPage.clickSignInButton();

        accPage.waitToBeVisible(accPage.welcomeMessage,10);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accPage.getTextFromElement(accPage.welcomeMessage));
        accPage.logOutButton.click();
        authPage.waitToBeVisible(accPage.breadcrumbHeader,10);
        Assertions.assertEquals("Authentication",accPage.getTextFromElement(accPage.breadcrumbHeader));
    }

    @Test
    @Order(4)
    @DisplayName("User cannot login with invalid credentials")
    void userCannotLoginWithInvalidUserAndPass(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.setRegisteredMail("truncho@mail.bg");
        authPage.setRegisteredPass("Ki838383838@");
        authPage.clickSignInButton();

        String actualErrorMessage = "Authentication failed.";
        Assertions.assertEquals(actualErrorMessage,authPage.getTextFromElement(authPage.errorMessage));
    }

}
