package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

public class LoginNegativeTests extends BaseTest {

    @ParameterizedTest(name = "[{index}] username={0}, password={1}")
    @CsvSource({
            "tomsmith, wrong_password, Your password is invalid!",
            "wrong_user, SuperSecretPassword!, Your username is invalid!",
            "'', SuperSecretPassword!, Your username is invalid!",
            "tomsmith, '', Your password is invalid!"
    })
    void shouldShowValidationMessageForInvalidLogin(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .open()
                .loginInvalidUser(username, password);

        Assertions.assertTrue(loginPage.getFlashMessage().contains(expectedMessage));
    }
}