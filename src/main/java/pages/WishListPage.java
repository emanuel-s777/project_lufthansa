package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    private WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    // No price filter found in the page to remove
    // public void removePriceFilter() {
    // WebElement removeFilterButton =
    // driver.findElement(By.cssSelector(".filter-clear"));
    // removeFilterButton.click();
    // }

    public boolean verifyWishListItemCount(int expectedCount) {
        int actualCount = driver.findElements(By.cssSelector(".product-item")).size();
        return actualCount == expectedCount;
    }

    // Don't understand where to find this
    // public boolean verifyWishListMessageDisplayed() {
    // WebElement messageElement =
    // driver.findElement(By.cssSelector(".message-success"));
    // return messageElement.isDisplayed();
    // }
}
