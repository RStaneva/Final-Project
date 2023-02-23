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

        //public boolean checkSessionIsInvalid(){
        // return driver.

        //}


   /*

   /*( Boolean isLogoutMessageDisplayed=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div")).isDisplayed();
            Assert.assertTrue(isLogoutMessageDisplayed,"The modal is not displayed");

            тестът минава.
            ДА се преобразува в метод, да се махнат асертъните


    public boolean isSuccessfulLogoutMessageDisplayed(){
        WebElement LogoutMessage=driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(LogoutMessage));

    }*/


/*


    public void StayLogoutAfterClickingBack(){
            //verify that if a user clicks on the back button of the browser after logout, the user should not be able to be redirected to a logged in mode application
            driver.navigate().back();
        }

        + w test assertion za newijdane na Profile i Lofout button, visible Sign in button

    @Test
    public Boolean isLogoutIconDisplayed(){
        //verVerify  After successful login in Gmail click on the profile icon to check logout button is visible or no
    }

*/






/*


    public void StayLogoutAfterClickingBack(){
            //verify that if a user clicks on the back button of the browser after logout, the user should not be able to be redirected to a logged in mode application
            driver.navigate().back();
        }

        + w test assertion za newijdane na Profile i Lofout button, visible Sign in button

    @Test
    public Boolean isLogoutIconDisplayed(){
        //verVerify  After successful login in Gmail click on the profile icon to check logout button is visible or no
    }

*/



/*
//този метод да се извика от логин пейджа само за проверка ассертион
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(LoginPage.PAGE_URL));
    }*/



}