package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSuccessfullyAddedToCartComponent extends BaseComponent {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckOutButton;

    @FindBy(css = "span.continue")
    private WebElement continueShoppingBtn;

    public ProductSuccessfullyAddedToCartComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void clickProceedCheckOut() {
        click(proceedToCheckOutButton);
    }

    public void getContinueShoppingBtn() {
        click(continueShoppingBtn);
    }

}
