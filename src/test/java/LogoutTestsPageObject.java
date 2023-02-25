import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webPages.pageObject.*;

import java.time.Duration;

public class LogoutTestsPageObject {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                {"myTestUser", "123456U", "myTestUser"}, //login with username
                {"testMail1@mail.bg", "123456U", "myTestUser"} //login with email
        };
    }

    @Test(dataProvider = "getUsers", invocationCount = 2)
    public void testLogout(String user, String password, String name) {
        Logout logout = new Logout(driver);
        LoginPage loginPage = new LoginPage(driver);
        Header header = new Header(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.navigateTo();
        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSignInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.signIn(user, password);

        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");
        header.clickProfile();

        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUserName = profilePage.getUsername();
        Assert.assertEquals(actualUserName, name, "The username is incorrect!");

        Assert.assertTrue(header.isLogoutIconDisplayed(), "Logout icon is not visible.");
        header.clickLogout();

        String logoutMessageText = logout.getMessageModalText();
        Assert.assertEquals(logoutMessageText, "Successful logout!");

        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login page URL is not loaded");

        logout.clickBackButton();
        Assert.assertTrue(header.isLoginButtonDisplayed(), "The session of the user is not ended");

    }
}



