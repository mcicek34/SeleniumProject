package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String loginButtonClass = "btnSignIn";
    private static final String testPageTitle = "GittiGidiyor - T?rkiye'nin ?nc? Al??veri? Sitesi";

    public void goToGittiGidiyor() {
        driver.get(baseURL);
    }

    public boolean isOnPage() {
        return driver.getTitle().contentEquals(testPageTitle);
    }

    public void goToLoginPage() {
        driver.get(baseURL);
        driver.findElement(By.className(loginButtonClass)).click();
    }
}