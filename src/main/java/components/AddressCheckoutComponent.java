package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class AddressCheckoutComponent extends BaseComponent {

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement processAddressBtn;

    @FindBy(xpath = "//label[contains(text(),'Choose a delivery address:')]")
    private WebElement deliveryAddressText;

    public AddressCheckoutComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Assert user is on address checkout component of checkout page")
    @Override
    public boolean  isElementDisplayed() {
        return waitForElementToBeDisplayed(deliveryAddressText, driver, PAGE_LOAD_TIMEOUT);
    }

    public void processBtn() {
        click(processAddressBtn);
    }

}
