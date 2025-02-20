package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomanCategoryPage {
    private WebDriver driver;
    private By topsCategory = By.linkText("Tops");
    private By jacketMenu = By.linkText("Jackets");

    public WomanCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverTopsCategory() {
        WebElement topsElement = driver.findElement(topsCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(topsElement).perform();
    }

    public void clickOnJacketMenu() {
        WebElement jacketElement = driver.findElement(jacketMenu);
        jacketElement.click();
    }
}
