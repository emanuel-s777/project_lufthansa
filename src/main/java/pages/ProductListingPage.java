package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.util.List;

public class ProductListingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void selectColorFilter(String color) {
        WebElement colorFilter = wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='filter-options-item']//a[contains(text(), '" + color + "')]")));
        colorFilter.click();
    }

    public void verifyFilteredProductsHaveColor(String color) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        for (WebElement product : products) {
            String productColor = product.findElement(By.cssSelector(".swatch-attribute.color .swatch-option"))
                    .getAttribute("aria-label");
            Assert.assertTrue("Product color does not match the filter", productColor.contains(color));
        }
    }

    public void selectPriceRange(String priceRange) {
        WebElement priceFilter = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='filter-options-item']//a[contains(text(), '" + priceRange + "')]")));
        priceFilter.click();
    }

    public void verifyFilteredProductsCount(int expectedCount) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        Assert.assertEquals("Filtered product count does not match", expectedCount, products.size());
    }

    public void verifyFilteredProductsPrice(String priceRange) {
        String[] prices = priceRange.split("-");
        double minPrice = Double.parseDouble(prices[0].replace("$", "").trim());
        double maxPrice = Double.parseDouble(prices[1].replace("$", "").trim());

        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        for (WebElement product : products) {
            double productPrice = Double.parseDouble(
                    product.findElement(By.cssSelector(".price")).getText().replace("$", "").trim());
            Assert.assertTrue("Product price is not within the range",
                    productPrice >= minPrice && productPrice <= maxPrice);
        }
    }

    public void addToWishList(int productIndex) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        WebElement wishListButton = products.get(productIndex).findElement(By.cssSelector(".towishlist"));
        wishListButton.click();
    }

    public void addToCart(int productIndex, String size) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        WebElement product = products.get(productIndex);
        WebElement sizeDropdown = product.findElement(By.cssSelector(".swatch-attribute.size .swatch-option"));
        sizeDropdown.click();
        WebElement sizeOption = sizeDropdown.findElement(By.xpath("//span[contains(text(), '" + size + "')]"));
        sizeOption.click();
        WebElement addToCartButton = product.findElement(By.cssSelector(".tocart"));
        addToCartButton.click();
    }
}
