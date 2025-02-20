package tests;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.WishListPage;


public class WishListTest extends BaseTest {

    private WishListPage wishListPage;

    @Before
    public void setUp() {
        super.setUp();
        wishListPage = new WishListPage(driver);
        driver.get("https://magento.softwaretestingboard.com/wishlist/");
    }

    @Test
    public void testWishList() {
        boolean isItemCountCorrect = wishListPage.verifyWishListItemCount(0);

        assertTrue("The wishlist item count is incorrect.", isItemCountCorrect);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}
