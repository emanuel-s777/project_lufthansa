package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openShoppingCart() {
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");
    }

    public boolean verifyShoppingCartPageLoaded() {
        return driver.getTitle().contains("Shopping Cart");
    }

    public boolean verifyItemsPriceMatchTotal() {
        List<WebElement> prices = driver.findElements(By.cssSelector(".cart-item .price"));
        double total = 0;
        for (WebElement price : prices) {
            total += Double.parseDouble(price.getText().replace("$", ""));
        }
        double displayedTotal = Double
                .parseDouble(driver.findElement(By.cssSelector(".grand.totals .price")).getText().replace("$", ""));
        return total == displayedTotal;
    }

    public void removeItemFromCart(int index) {
        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".action-delete"));
        if (index < removeButtons.size()) {
            removeButtons.get(index).click();
        }
    }

    public boolean verifyCartItemCount(int expectedCount) {
        List<WebElement> items = driver.findElements(By.cssSelector(".cart.item"));
        return items.size() == expectedCount;
    }

    public boolean verifyEmptyCartMessage() {
        return driver.findElement(By.cssSelector(".cart-empty .message")).isDisplayed();
    }
}
