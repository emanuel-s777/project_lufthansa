package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.SignInPage;

public class SignInTest extends BaseTest {

    private SignInPage signInPage;

    @Before
    public void setUp() {
        super.setUp();
        signInPage = new SignInPage(driver);
        driver.get(" https://magento.softwaretestingboard.com/customer/account/login");
    }

    @Test
    public void testSignIn() {
        signInPage.enterEmail("jason.statham@gmail.com");
        signInPage.enterPassword("Password123!");
        signInPage.clickSignInButton();
        signInPage.verifyUserIsLoggedIn();
        signInPage.signOut();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}
