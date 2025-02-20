package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ShoppingCartPage;


public class ShoppingCartTest extends BaseTest {

    private ShoppingCartPage shoppingCartPage;

    @Before
    public void setUp() {
        super.setUp();
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShoppingCart();
    }

    @Test
    public void testShoppingCart() {
        assertTrue(shoppingCartPage.verifyShoppingCartPageLoaded());
        assertTrue(shoppingCartPage.verifyItemsPriceMatchTotal());
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}