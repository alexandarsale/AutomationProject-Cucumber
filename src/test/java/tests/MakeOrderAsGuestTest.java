package tests;

import components.AddressCheckoutComponent;
import components.PaymentComponent;
import components.ShippingComponent;
import components.SummaryComponent;
import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.TestAllureListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AlreadyRegisteredPage;
import pages.ItemCheckOutPage;
import pages.OrderConfirmationPage;
import pages.ShirtsPage;

import static org.testng.Assert.assertTrue;

@Listeners({TestAllureListeners.class})
public class MakeOrderAsGuestTest extends BaseTest {
    @Description("This test is used to assert purchasing products as a guest")
    @Severity(SeverityLevel.NORMAL)
    @Story("Ordering products as a guest")
    @Test(description = "Navigate to the site and make order as guest")
    public static void orderAsGuestTest() {

        ShirtsPage shirtsPage = new ShirtsPage(DriverManager.getDriver());

        //Click on T-shirts tab, verify that it is opened and add a product to cart
        shirtsPage.clickOnTShirtButton();

        assertTrue(shirtsPage.isOpened());

        shirtsPage.hoverOverItemAndClickAddToCartButton();

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());

        //Assert that item is added to cart and checkout page is opened, and make an order
        assertTrue(itemCheckOutPage.isOpened());

        itemCheckOutPage.clickProceedCheckOutButton();

        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();

        AlreadyRegisteredPage arPage = new AlreadyRegisteredPage(DriverManager.getDriver());

        //Enter valid credentials and login to proceed checkout
        arPage.setLogInData();

        //Continue with checkout order
        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickConfirmOrderBtn();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());

        //Assert that order is completed
        assertTrue(orderConfirmationPage.isOpened());
    }
}
