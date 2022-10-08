package pages;

import components.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class ItemCheckOutPage extends BasePage{

    private final ProductSuccessfullyAddedToCartComponent prAdded;
    private final AddressCheckoutComponent checkout;
    private final PaymentComponent payment;
    private final ShippingComponent shippingComponent;
    private final SummaryComponent summaryComponent;
    private final OrderStepsComponent orderStepsComponent;

    @FindBy(css = "div.layer_cart_product")
    private WebElement itemAddedToCartText;

    @FindBy(css = "label[for='id_address_delivery']")
    private WebElement deliveryAddressText;

    public ItemCheckOutPage(WebDriver driver) {
        super(driver);
        prAdded = new ProductSuccessfullyAddedToCartComponent(driver);
        checkout = new AddressCheckoutComponent(driver);
        payment = new PaymentComponent(driver);
        shippingComponent = new ShippingComponent(driver);
        summaryComponent = new SummaryComponent(driver);
        orderStepsComponent = new OrderStepsComponent(driver);
    }

    @Step("Asserting that product is added to cart")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(itemAddedToCartText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    public boolean isElementDisplayed() {
         return waitForElementToBeDisplayed(deliveryAddressText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Step("User clicks on proceed checkout btn")
    public void clickProceedCheckOutButton(){
        prAdded.clickProceedCheckOut();
    }

    @Step("User clicks on continue shopping btn")
    public void clickContinueShoppingBtn(){
        prAdded.getContinueShoppingBtn();
    }

    @Step("User clicks on proceed btn")
    public void clickProceedBtn(){
        summaryComponent.proceedBtn();
    }

    @Step("User increases quantity by given number")
    public void addQuantityBtn(){
        summaryComponent.enterQuantity("2");
    }

    @Step("User clicks on summary step btn in checkout page")
    public void clickSummaryStep(){
        orderStepsComponent.getSummaryStep();
    }

    public void substractQuantityBtn(){
        summaryComponent.subtractQuantity();
    }

    @Step("User checks the terms and conditions")
    public void checkTermsAndConditions(){
        shippingComponent.termsAndConditions();
    }

    @Step("User selects payment via bank")
    public void selectPaymentViaBank(){
        payment.bankPayment();
    }

    public void selectPaymentViaCheck(){
        payment.checkPayment();
    }

    @Step("User clicks on confirm order btn")
    public void clickConfirmOrderBtn(){
        payment.confirmOrder();
    }

    @Step("User clicks on process btn")
    public void clickProcessBtn(){
        checkout.processBtn();
    }
    @Step("User clicks on carrier btn")
    public void clickCarrierBtn(){
       shippingComponent.carrierBtn();
    }
}
