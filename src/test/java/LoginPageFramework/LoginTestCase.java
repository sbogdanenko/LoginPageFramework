package LoginPageFramework;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTestCase extends BaseTest {
    LoginPage loginPage;

    @Test
    void successfulLoginTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputValidCredentials(LoginTestData.VALID_USERNAME,LoginTestData.VALID_PASSWORD);
        loginPage.submit();
        loginPage.validateSuccessfulLogin();
    }

    @Test
    void failedLoginTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputInvalidLogin(LoginTestData.INVALID_USERNAME, LoginTestData.VALID_PASSWORD);
        loginPage.submit();
        loginPage.validateFailedLogin();
    }

    @Test
    void failedPasswordTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputInvalidPassword(LoginTestData.VALID_USERNAME,LoginTestData.INVALID_PASSWORD);
        loginPage.submit();
        loginPage.validateFailedPassword();
    }
}



