package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ShoppingCartPage;


public class EmptyShoppingCartTest extends BaseTest {

    private ShoppingCartPage shoppingCartPage;

    @Before
    public void setUp() {
        super.setUp();
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShoppingCart();
    }

    @Test
    public void testEmptyShoppingCart() {
        shoppingCartPage.removeItemFromCart(0);
        assertTrue(shoppingCartPage.verifyCartItemCount(0));
        assertTrue(shoppingCartPage.verifyEmptyCartMessage());
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}
