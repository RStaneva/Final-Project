package webPages.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {
    private final WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessageModalText() {
        WebElement message = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }

    public Boolean isLogoutIconDisplayed() {
        WebElement logoutIcon = driver.findElement(By.xpath("//ul[@class='navbar-nav my-ml d-none d-md-block']//li[@class='nav-item ng-star-inserted']//a[@class='nav-link']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return logoutIcon.isDisplayed();
    }

    public void clickBackButton() {
        driver.navigate().back();
    }
}