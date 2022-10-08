package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class PaymentComponent extends BaseComponent {

    @FindBy(css = "a.bankwire")
    private WebElement payViaBankWire;

    @FindBy(css = "a.cheque")
    private WebElement payViaCheck;

    @FindBy(css = "button.button")
    private WebElement confirmOrderButton;

    @FindBy(css = "#HOOK_PAYMENT")
    private WebElement paymentOptionText;

    public PaymentComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Assert user is on payment component of checkout page")
    @Override
    public boolean isElementDisplayed() {
        return waitForElementToBeDisplayed(paymentOptionText, driver, PAGE_LOAD_TIMEOUT);
    }

    public void bankPayment() {
        click(payViaBankWire);
    }

    public void checkPayment() {
        click(payViaCheck);
    }

    public void confirmOrder() {
        click(confirmOrderButton);
    }
}
