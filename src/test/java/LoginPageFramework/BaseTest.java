package LoginPageFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    @Parameters("browser")
    public void driverInitiate(@Optional("chrome") String browser) {
        if (driver == null) {
            logger.info("Starting tests in browser: " + browser);
            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("/usr/bin/google-chrome");
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
    }

    @AfterClass
    public void driverClose() {
        if (driver != null) {
            logger.info("Closing browser...");
            driver.quit();
            driver = null;
        }
    }

    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
