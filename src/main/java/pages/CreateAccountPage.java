package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class CreateAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.cssSelector("button[title='Create an Account']");
    private By successMessage = By.cssSelector(".message-success > div");
    private By signOutButton = By.linkText("Sign Out");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void verifyPageTitle(String expectedTitle) {
        assertEquals(expectedTitle, driver.getTitle());
    }

    public void fillFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(email);
    }

    public void fillPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPasswordElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
        confirmPasswordElement.sendKeys(password);
    }

    public void clickCreateAccountButton() {
        WebElement createAccountButtonElement = wait
                .until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButtonElement.click();
    }

    public void verifySuccessMessage(String expectedMessage) {
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        assertEquals(expectedMessage, successMessageElement.getText());
    }

    public void signOut() {
        WebElement signOutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(signOutButton));
        signOutButtonElement.click();
    }
}
