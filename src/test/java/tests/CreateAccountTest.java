package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {

    private CreateAccountPage createAccountPage;

    @Before
    public void setUp() {
        super.setUp();
        createAccountPage = new CreateAccountPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @Test
    public void testCreateAccount() {
        createAccountPage.fillFirstName("Jason");
        createAccountPage.fillLastName("Statham");
        createAccountPage.fillEmail("jason.statham@gmail.com");
        createAccountPage.fillPassword("Password123!");
        createAccountPage.confirmPassword("Password123!");
        createAccountPage.clickCreateAccountButton();
        createAccountPage.signOut();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}