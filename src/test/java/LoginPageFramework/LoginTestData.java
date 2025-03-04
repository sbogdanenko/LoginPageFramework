package LoginPageFramework;

public class LoginTestData {
    public static final String BASE_URL = "https://practicetestautomation.com/practice-test-login/";
    public static final String SUCCESS_URL = "https://practicetestautomation.com/logged-in-successfully/";

    // Valid Credentials
    public static final String VALID_USERNAME = "student";
    public static final String VALID_PASSWORD = "Password123";

    // Invalid Credentials
    public static final String INVALID_USERNAME = "user";
    public static final String INVALID_PASSWORD = "qwerty123";

    // Expected Messages
    public static final String BASE_PAGE_TITLE = "Test Login | Practice Test Automation";
    public static final String SUCCESS_LOGIN_MESSAGE = "Logged In Successfully | Practice Test Automation";
    public static final String FAILED_LOGIN_MESSAGE = "Your username is invalid!";
    public static final String FAILED_PASSWORD_MESSAGE = "Your password is invalid!";
}