package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.id("send2");
    private By accountMenu = By.cssSelector(".logged-in[data-bind*='Welcome']");
    private By signOutLink = By.cssSelector("a[data-post*='customer/account/logout/']");

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
    }

    // Methods
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButtonElement = driver.findElement(signInButton);
        signInButtonElement.click();
    }

    public boolean verifyUserIsLoggedIn() {
        try {
            WebElement accountMenuElement = driver.findElement(accountMenu);
            return accountMenuElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void signOut() {
        try {
            WebElement accountMenuElement = driver.findElement(accountMenu);
            accountMenuElement.click();
            wait.until(ExpectedConditions.elementToBeClickable(signOutLink)); // Wait until sign out link is clickable
            WebElement signOutLinkElement = driver.findElement(signOutLink);
            signOutLinkElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
