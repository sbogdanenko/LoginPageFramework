package LoginPageFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;


public class LoginPage extends BaseTest{
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By errorMessage = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void openBasePage(String url) {
        driver.get(url);
        String loginTitle = driver.getTitle();
        assertEquals(loginTitle, LoginTestData.BASE_PAGE_TITLE, "Page title should match");
    }

    public void inputValidCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void inputInvalidLogin(String badLogin, String password) {
        driver.findElement(usernameField).sendKeys(badLogin);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void inputInvalidPassword(String login, String BadPassword) {
        driver.findElement(usernameField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(BadPassword);
    }



    public void submit() {
        driver.findElement(submitButton).click();
    }

    public void validateSuccessfulLogin() {
    String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl,
                LoginTestData.SUCCESS_URL,
                "Successful login page should appear");
        String successfulLoginTitle = driver.getTitle();
        assertEquals(successfulLoginTitle, LoginTestData.SUCCESS_LOGIN_MESSAGE, "Page title should match");
    }

    public void validateFailedLogin() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, LoginTestData.BASE_URL, "Base page should appear");
        String actualLoginErrorMessage = getErrorMessage();
        logger.info("Captured login error message: {}", actualLoginErrorMessage);
        assertEquals(actualLoginErrorMessage, LoginTestData.FAILED_LOGIN_MESSAGE, "Error message should appear");
    }

    public void validateFailedPassword() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, LoginTestData.BASE_URL, "Base page should appear");
        String actualPasswordErrorMessage = getErrorMessage();
        logger.info("Captured password error message: {}", actualPasswordErrorMessage);
        assertEquals(actualPasswordErrorMessage, LoginTestData.FAILED_PASSWORD_MESSAGE, "Error message should appear");
    }

    public String getErrorMessage(){
        waitForElementToBeVisible(errorMessage);
        return driver.findElement(errorMessage).getText();
    }

}
