package pages;

import components.TShirtsComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class ShirtsPage extends BasePage{

    private final  TShirtsComponent tShirtsComponent;

    @FindBy(xpath = "//p[contains(text(),'The must have of your wardrobe, take a look at our')]")
    private WebElement tshirtPageText;

    public ShirtsPage(WebDriver driver) {
        super(driver);
        tShirtsComponent = new TShirtsComponent(driver);
    }

    @Step("User asserts t-shirt page is opened")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(tshirtPageText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    @Step("User clicks on TShirt Section")
    public void clickOnTShirtButton(){
        tShirtsComponent.tshirtButton();
    }

    @Step("User adds first t-shirt product to cart")
    public void hoverOverItemAndClickAddToCartButton(){
        tShirtsComponent.hoverOverItem();
    }
}
