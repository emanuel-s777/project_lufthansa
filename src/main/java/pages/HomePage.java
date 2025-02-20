package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void clickCreateAccountLink() {
        driver.findElement(By.linkText("Create an Account")).click();
    }

    public void clickSignInLink() {
        driver.findElement(By.linkText("Sign In")).click();
    }

    public void clickWomenCategory() {
        driver.findElement(By.linkText("Women")).click();
    }
}
