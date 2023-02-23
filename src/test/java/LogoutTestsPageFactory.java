import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webPages.pageObject.*;

import java.time.Duration;

public class LogoutTestsPageFactory {
    private WebDriver driver;

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{{"DimitarTarkalanov", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"}, //login with username
                //{"testMail1@gmail.com", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"}, //login with email
                //{"testAdmin@gmail.com", "Admin1.User1", "AdminUser"}, //login with admin user
                //{"manager@gmail.com", "Manager1.Use1", "ManagerUser"} //login with manager user
        };
    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
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


    @Test
    public void testLogout(){
        Logout logout= new Logout (driver);
        LoginPage login= new LoginPage (driver);
        Header header=new Header (driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

            homePage.navigateTo();
            header.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
            String signInText = loginPage.getSignInElementText();
            Assert.assertEquals(signInText, "Sign in");
            loginPage.populateUsername();
            loginPage.populatePassword();
            loginPage.clickSignIn();

            Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");
            header.clickProfile();

            Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
            String actualUserName = profilePage.getUsername();
            String name= "Dimitar Tarkalanov";
            Assert.assertEquals(actualUserName, name, "The username is incorrect!");

       // logout.isLogoutIconDisplayed();
        header.clickLogout();

        //String logoutMessageText=logout.getMessageModalText();
       // Assert.assertEquals(logoutMessageText, "Successful logout!");

        Assert.assertTrue(login.isUrlLoaded(), "The Login page URL is not loaded");

       //logout.clickBackbutton();
        //Assert.assertTrue(logout. checkSessionIsInvalid(), "The user is not logged out");
        }
    }

