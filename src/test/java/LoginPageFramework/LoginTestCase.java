package LoginPageFramework;

import io.qameta.allure.*;
import org.testng.annotations.Test;


public class LoginTestCase extends BaseTest {
    LoginPage loginPage;

    @Test
    @Description("Verify login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Tests")

    void successfulLoginTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputValidCredentials(LoginTestData.VALID_USERNAME,LoginTestData.VALID_PASSWORD);
        loginPage.submit();
        loginPage.validateSuccessfulLogin();
    }

    @Test
    @Description("Verify login with invalid username")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Tests")

    void failedLoginTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputInvalidLogin(LoginTestData.INVALID_USERNAME, LoginTestData.VALID_PASSWORD);
        loginPage.submit();
        loginPage.validateFailedLogin();
    }

    @Test
    @Description("Verify login with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Tests")
    void failedPasswordTest() {
        loginPage = new LoginPage(driver);

        loginPage.openBasePage(LoginTestData.BASE_URL);
        loginPage.inputInvalidPassword(LoginTestData.VALID_USERNAME,LoginTestData.INVALID_PASSWORD);
        loginPage.submit();
        loginPage.validateFailedPassword();
    }
}



