package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class ShippingComponent extends BaseComponent {

    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement processCarrierBtn;

    @FindBy(css = "#cgv")
    private WebElement termsAndConditionsBox;

    @FindBy(xpath = "//p[contains(text(),'Choose a shipping option for this address: My addr')]")
    private WebElement shippingOptionText;

    public ShippingComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Assert user is on shipping component of checkout page")
    @Override
    public boolean isElementDisplayed() {
        return waitForElementToBeDisplayed(shippingOptionText, driver, PAGE_LOAD_TIMEOUT);
    }

    public void carrierBtn() {
        click(processCarrierBtn);
    }

    public void termsAndConditions() {
        click(termsAndConditionsBox);
    }
}
