package webPages.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
    }

    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public Boolean isLoginButtonDisplayed() {
        WebElement signInIcon = driver.findElement(By.id("nav-link-login"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return signInIcon.isDisplayed();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutLink = driver.findElement(By.xpath("//ul[@class='navbar-nav my-ml d-none d-md-block']//li[@class='nav-item ng-star-inserted']//a[@class='nav-link']"));
        By locator = By.xpath("//ul[@class='navbar-nav my-ml d-none d-md-block']//li[@class='nav-item ng-star-inserted']//a[@class='nav-link']");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        logoutLink.click();
    }

    public Boolean isLogoutIconDisplayed() {
        WebElement logoutIcon = driver.findElement(By.xpath("//ul[@class='navbar-nav my-ml d-none d-md-block']//li[@class='nav-item ng-star-inserted']//a[@class='nav-link']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return logoutIcon.isDisplayed();
    }
}


