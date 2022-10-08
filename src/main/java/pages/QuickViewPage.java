package pages;

import components.QuickViewComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class QuickViewPage extends BasePage {

    private final QuickViewComponent quickViewComponent;

    //This locator is used to verify that the popup text is displayed after adding an item to wishlist
    @FindBy(css = "p.fancybox-error")
    private WebElement itemAddedToWishListTxt;

    public QuickViewPage(WebDriver driver) {
        super(driver);
        quickViewComponent = new QuickViewComponent(driver);
    }

    @Step("Asserting quick-view page of product is opened")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(itemAddedToWishListTxt, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void clickOnQuickViewBtn() {
        quickViewComponent.getQuickViewBtn();
    }

    public void clickWishListBtn() {
        quickViewComponent.getWishListBtn();
    }

    public void clickWishList() {
        quickViewComponent.getWishList();
    }

    @Step("User clicks on close btn")
    public void clickCloseBtn() {
        quickViewComponent.getCloseBtn();
    }

    public void clickContinueBtn() {
        quickViewComponent.getContinue();
    }

    public void clickMoreBtn() {
        quickViewComponent.getMoreBtn();
    }
}
