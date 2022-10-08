package tests;

import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.TestAllureListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import productValidation.ValidateProduct;

import static org.testng.Assert.assertTrue;
@Listeners({TestAllureListeners.class})
public class AddItemsToWishListTest extends BaseTest {
    @Description("Verifying user can purchase products from the specials menu")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Adding products from specials to wishlist")
    @Test(description = "Add specials products to wishList")
    public static void addItemsToWishList() {

        HomePage home = new HomePage(DriverManager.getDriver());

        //Assert home page is opened and click signIn btn
        assertTrue(home.isOpened());

        home.clickOnSignUpButton();

        AlreadyRegisteredPage arPage = new AlreadyRegisteredPage(DriverManager.getDriver());

        //Assert login page is opened, enter valid credentials and login
        assertTrue(arPage.isOpened());

        arPage.setLogInData();

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());

        //Assert that my account page is opened
        assertTrue(myAccountPage.isOpened());

        ShirtsPage shirtsPage = new ShirtsPage(DriverManager.getDriver());

        //Click on T-shirts tab, verify that it is opened and add a product to cart
        shirtsPage.clickOnTShirtButton();

        assertTrue(shirtsPage.isOpened());

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());

        //Click on Specials Button and assert that page is opened
        priceDropPage.clickOnSpecialsBtn();

        assertTrue(priceDropPage.isOpened());
        priceDropPage.clickListsBtn();
        priceDropPage.clickWishBtn();

        QuickViewPage quickViewPage = new QuickViewPage(DriverManager.getDriver());

        //Open quickView - menu on first product and add it to wishlist, assert that product is added to wishlist
        assertTrue(quickViewPage.isOpened());
        quickViewPage.clickCloseBtn();
        priceDropPage.clickSecondWishBtn();
        quickViewPage.clickCloseBtn();
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());

        //Open account menu and click on My wishlists
        navigationBarPage.clickAccountBtn();
        //Verify my account is opened
        assertTrue(myAccountPage.isOpened());
        myAccountPage.clickMyWishlists();
        //Verify my wishlist is opened
        assertTrue(myAccountPage.isElementDisplayed());
        myAccountPage.clickWishlistProducts();

        //Validate that correct product is added to wishlist
        ValidateProduct validateProduct = new ValidateProduct(DriverManager.getDriver());
        assertTrue(validateProduct.isTextPresent("Printed Chiffon Dress"));
        assertTrue(validateProduct.isTextPresent("Printed Summer Dress"));
    }
}
