package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class SummaryComponent extends BaseComponent {

    @FindBy(xpath = "//p//a[@title='Proceed to checkout']")
    private WebElement proceedBtn;

    @FindBy(css = "a.cart_quantity_up")
    private WebElement increaseQuantityBtn;

    @FindBy(css = "a.cart_quantity_down")
    private WebElement decreaseQuantityBtn;

    @FindBy(css = "#summary_products_quantity")
    private WebElement productQuantityText;

    @FindBy(css = "input.cart_quantity_input")
    private List<WebElement> quantityInput;

    @FindBy(css = "#cart_title")
    private WebElement shoppingCartSummaryText;

    public SummaryComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Assert user is on summary component of checkout page")
    @Override
    public boolean isElementDisplayed() {
        return waitForElementToBeDisplayed(shoppingCartSummaryText, driver, PAGE_LOAD_TIMEOUT);
    }

    public void proceedBtn() {
        click(proceedBtn);
    }

    public void addQuantity() {
        for (int i = 1; i <= 1; i++) {
            click(increaseQuantityBtn);
        }
    }

    public void enterQuantity(String quantity) {
        sendKeys(quantityInput.get(0), quantity);
    }

    public void subtractQuantity() {
        click(decreaseQuantityBtn);
    }
}
