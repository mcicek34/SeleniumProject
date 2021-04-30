package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static String productPrice;

    private By addBasket = By.id("add-to-basket");
    private By productPriceId = By.id("sp-price-highPrice");
    private By basketXpath = By.xpath("//a[@class='header-cart-hidden-link']");
    private By basketLinkPath = By.className("dIB");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        wait = new WebDriverWait(driver, 30);
    }

    public void clickAddBasket() {

        wait.until(ExpectedConditions.presenceOfElementLocated(addBasket));
        WebElement webElement = driver.findElement(addBasket);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        wait.until(ExpectedConditions.presenceOfElementLocated(productPriceId));
        productPrice = driver.findElement(productPriceId).getText();
    }

    public BasketPage clickBasketPage() {

        wait.until(ExpectedConditions.elementToBeClickable(basketLinkPath));
        driver.findElement(basketLinkPath).click();
        return new BasketPage(driver, wait);


    }
}
