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
    AuthenticationPage authenticationPage;
    AccountPage accountPage;

    @Test
    @Order(1)
    @DisplayName("Create an account")
    void userCanCreateAccount(){
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authenticationPage.setEmailAddress("kikoProbenUser@mail.bg"); // can change for the next cycle
        authenticationPage.clickCreateAccountButton();
        authenticationPage.waitToBeVisible(accountPage.authenticationHeaderPage,2);
        Assertions.assertEquals("Authentication",accountPage.getTextFromElement(accountPage.authenticationHeaderPage));
        scrollToElement(accountPage.personalInformationBlock);
        accountPage.populatePersonalInfo("Kiko","Kikonev","kikoProbenUser@mail.bg","Proba123@");
        scrollToElement(accountPage.personalAddress);
        accountPage.populatePersonalAddress("Kikcho","Kikchov","Lozenets, Sofia 1000","Sofia","75201","0877227711","Kiko@proben.bg");
        scrollToElement(accountPage.registerButton);
        accountPage.registerButton.click();
        accountPage.waitToBeVisible(accountPage.welcomeMessage,3);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accountPage.getTextFromElement(accountPage.welcomeMessage));
    }
    @Test
    @Order(2)
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidEmailAndPassword(){
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
        homePage.clickSignInButton();
        authenticationPage.setRegisteredMail("kikoProbenUser@mail.bg");
        authenticationPage.setRegisteredPass("Kiko123@");
        authenticationPage.clickSignInButton();
        accountPage.waitToBeVisible(accountPage.welcomeMessage,3);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accountPage.getTextFromElement(accountPage.welcomeMessage));
    }
    @Test
    @Order(3)
    @DisplayName("User can login and logout")
    void userCanLoginWithAndLogout(){
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
        homePage.clickSignInButton();
        authenticationPage.setRegisteredMail("kikoProbenUser@mail.bg");
        authenticationPage.setRegisteredPass("Kiko123@");
        authenticationPage.clickSignInButton();
        accountPage.waitToBeVisible(accountPage.welcomeMessage,3);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accountPage.getTextFromElement(accountPage.welcomeMessage));
        accountPage.logOutButton.click();
        Assertions.assertEquals("Authentication",accountPage.getTextFromElement(accountPage.authenticationHeaderPage));
    }
    @Test
    @Order(4)
    @DisplayName("User cannot login with invalid credentials")
    void userCannotLoginWithInvalidUserAndPass(){
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountPage = new AccountPage(driver);
        homePage.clickSignInButton();
        authenticationPage.setRegisteredMail("truncho@mail.bg");
        authenticationPage.setRegisteredPass("Ki838383838@");
        authenticationPage.clickSignInButton();
        String actualErrorMessage = "Authentication failed.";
        Assertions.assertEquals(actualErrorMessage,accountPage.getTextFromElement(accountPage.errorMessage));
    }


}
