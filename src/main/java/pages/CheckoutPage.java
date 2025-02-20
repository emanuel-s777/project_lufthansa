package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("button[title='Proceed to Checkout']"));
        checkoutButton.click();
    }

    public boolean verifyCheckoutPageLoaded() {
        WebElement checkoutHeader = driver.findElement(By.cssSelector("h1.page-title span"));
        return checkoutHeader.isDisplayed();
    }
}
