package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        SecureAreaPage secureAreaPage = loginPage
                .open()
                .loginValidUser("tomsmith", "SuperSecretPassword!");

        Assertions.assertTrue(secureAreaPage.isOpened());
        Assertions.assertEquals("Secure Area", secureAreaPage.getHeaderText());
        Assertions.assertTrue(secureAreaPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    void shouldLogoutSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);

        SecureAreaPage secureAreaPage = loginPage
                .open()
                .loginValidUser("tomsmith", "SuperSecretPassword!");

        LoginPage returnedLoginPage = secureAreaPage.logout();

        Assertions.assertTrue(returnedLoginPage.getFlashMessage().contains("You logged out of the secure area!"));
    }
}