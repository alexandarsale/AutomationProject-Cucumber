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
import pages.*;

import static org.testng.Assert.assertTrue;

@Listeners({TestAllureListeners.class})
public class MakeOrderWithIncreasedQuantityTest extends BaseTest {

    @Description("This test is used to assert the checkout functionality of the store")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Increasing product quantity in checkout page")
    @Test(description = "Add item to cart increase the order quantity and purchase item")
    public static void addQuantityToOrder() {

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

        shirtsPage.hoverOverItemAndClickAddToCartButton();

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());

        //Assert that item is added to cart and checkout page is opened, and make an order
        assertTrue(itemCheckOutPage.isOpened());

        itemCheckOutPage.clickProceedCheckOutButton();

        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();

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
        itemCheckOutPage.clickSummaryStep();
        itemCheckOutPage.addQuantityBtn();

        //Assert that user is on checkout page menu and can finish the order
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();
        //Assert that user is on the right checkout page
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();
        //Assert that user can check shipping options
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();
        //Assert that user can choose payment option
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();

        itemCheckOutPage.clickConfirmOrderBtn();

        //Assert that order is completed
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }
}
