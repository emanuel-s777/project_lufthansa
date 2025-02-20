package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFilterTest {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Magento test website
            driver.get("https://magento.softwaretestingboard.com/");
            Thread.sleep(4000);

            // Search for a product
            WebElement searchBox = driver.findElement(By.id("search"));
            searchBox.sendKeys("shirt");
            searchBox.submit();
            Thread.sleep(4000);

            // Click on the product from the search results
            WebElement productLink = driver.findElement(By.cssSelector(".product-item-link"));
            productLink.click();
            Thread.sleep(4000);

            // Select size
            WebElement sizeOption = driver.findElement(By.cssSelector(".swatch-attribute.size .swatch-option"));
            sizeOption.click();
            Thread.sleep(4000);

            // Select color
            WebElement colorOption = driver.findElement(By.cssSelector(".swatch-attribute.color .swatch-option"));
            colorOption.click();
            Thread.sleep(4000);

            // Click on the "Add to Cart" button
            WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
            addToCartButton.click();
            Thread.sleep(4000);

            // Verify that the product is added to the cart
            WebElement cartCount = driver.findElement(By.cssSelector(".counter"));
            String itemCount = cartCount.getText().replaceAll("[^0-9]", "").trim();
            System.out.println("Cart Count: " + Integer.parseInt(itemCount));
            if (Integer.parseInt(itemCount) > 0) {
                System.out.println("Test Passed: Product successfully added to the cart.");
            } else {
                System.out.println("Test Failed: Product not added to the cart.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}