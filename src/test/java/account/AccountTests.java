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
    void CreateAnAccount_TC1(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.waitToBeVisible(authPage.emailAddressForCreateAccount_field,10);
        // Email can change for the next test!
        authPage.setTextToField(authPage.emailAddressForCreateAccount_field,"mislead3@mail.bg");
        authPage.clickCreateAccount_btn();
        // Wait to be visible account page for populating all fields
        accPage.waitToBeVisible(accPage.breadcrumbHeader,10);
        Assertions.assertEquals("Authentication",accPage.getTextFromElement(accPage.breadcrumbHeader));
        // Populate the first block elements
        accPage.scrollToElement(accPage.personalInformation);
        // Email can change for the next test!
        accPage.populatePersonalInfo("Kiko","Kikonev","mislead3@mail.bg","Proba123@");
        // Populate the second block elements
        accPage.scrollToElement(accPage.personalAddress);
        // Email can change for the next test!
        accPage.populatePersonalAddress("Kikcho","Kikchov","Lozenets, Sofia 1000","Sofia","75201","0877227711","mislead@reference3.bg");
        // Click register button
        accPage.scrollToElement(accPage.register_btn);
        accPage.register_btn.click();
        // Wait until welcome message for logged acc is displayed
        accPage.waitToBeVisible(accPage.welcomeMessage,10);
        accPage.scrollToElement(accPage.welcomeMessage);
        String actualMessageAfterCreateAccount = "Welcome to your account. Here you can manage all of your personal information and orders.";
        Assertions.assertEquals(actualMessageAfterCreateAccount,accPage.getTextFromElement(accPage.welcomeMessage));
    }
    @Test
    @Order(2)
    @DisplayName("Cannot create an account with exist Email")
    void userCannotCreateAccountWithExistEmail_TC2() {
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.waitToBeVisible(authPage.emailAddressForCreateAccount_field, 10);
        // Email can change for the next test (1)
        authPage.setTextToField(authPage.emailAddressForCreateAccount_field, "mislead@mail.bg");
        authPage.clickCreateAccount_btn();
        String actualAccErrorMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        Assertions.assertEquals(actualAccErrorMessage,authPage.getTextFromElement(authPage.accErrorMessage));
    }
    @Test
    @Order(3)
    @DisplayName("User can login with valid credentials")
    void userCanLoginWithValidEmailAndPassword_TC3(){
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
    @Order(4)
    @DisplayName("User can login and logout from his account")
    void userCanLogInAndLogout_TC4(){
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
    @Order(5)
    @DisplayName("User CANNOT login with invalid email")
    void userCannotLoginWithInvalidEmailText_TC5(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.setRegisteredMail("trunchomail.bg");
        authPage.setRegisteredPass("123123");
        authPage.clickSignInButton();

        String actualErrorMessage = "Invalid email address.";
        Assertions.assertEquals(actualErrorMessage,authPage.getTextFromElement(authPage.errorMessage));
    }
    @Test
    @Order(5)
    @DisplayName("User CANNOT login only with password")
    void userCannotLoginWithInvalidPassword_TC6(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.setRegisteredPass("19291929192");
        authPage.clickSignInButton();

        String actualErrorMessage = "An email address required.";
        Assertions.assertEquals(actualErrorMessage,authPage.getTextFromElement(authPage.errorMessage));
    }

    @Test
    @Order(6)
    @DisplayName("User CANNOT login with invalid credentials")
    void userCannotLoginWithInvalidUserAndPass_TC7(){
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
    @Test
    @Order(7)
    @DisplayName("User CANNOT login with empty fields")
    void userCannotLoginWithEmptyFields_TC8(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.setRegisteredMail("");
        authPage.setRegisteredPass("");
        authPage.clickSignInButton();

        String actualErrorMessage = "Authentication failed.";
        Assertions.assertEquals(actualErrorMessage,authPage.getTextFromElement(authPage.errorMessage));
    }

    @Test
    @Order(8)
    @DisplayName("Try to create account without required fields")
    void userCannotCreateAccountWithoutRequiredFields_TC9(){
        homePage = new HomePage(driver);
        authPage = new AuthenticationPage(driver);
        accPage = new AccountPage(driver);

        homePage.clickSignInButton();
        authPage.waitToBeVisible(authPage.emailAddressForCreateAccount_field,10);

        authPage.setTextToField(authPage.emailAddressForCreateAccount_field,"misleadRequired@mail.bg");
        authPage.clickCreateAccount_btn();
        // Wait to be visible account page for populating all fields
        accPage.waitToBeVisible(accPage.breadcrumbHeader,10);
        Assertions.assertEquals("Authentication",accPage.getTextFromElement(accPage.breadcrumbHeader));
        // Populate the first block elements
        accPage.scrollToElement(accPage.personalInformation);
        accPage.populatePersonalInfo("Kiko","Kikonev","misleadRequired@mail.bg","Proba123@");
        // Click register button
        accPage.scrollToElement(accPage.register_btn);
        accPage.register_btn.click();
        // Wait until error message is displayed for empty required fields
        accPage.waitToBeVisible(accPage.errorRequiredMessage,10);
        accPage.scrollToElement(accPage.errorRequiredMessage);
        Assertions.assertTrue(accPage.errorRequiredMessage.getText().contains("error"),"Changed!");
    }
}
