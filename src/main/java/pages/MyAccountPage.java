package pages;

import components.MyAccountComponent;
import components.WishListComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class MyAccountPage extends BasePage {

    private final MyAccountComponent myAccountComponent;
    private final WishListComponent wishListComponent;

    //This page us used to verify that we are successfully logged in
    @FindBy(css = "p.info-account")
    private WebElement myAccountText;

    //This element is used to verify my wishlist is opened
    @FindBy(xpath = "//h3[contains(text(),'New wishlist')]")
    private WebElement myWishListText;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        myAccountComponent = new MyAccountComponent(driver);
        wishListComponent = new WishListComponent(driver);
    }

    @Step("User verifies if login is successful")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(myAccountText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Step("Asserting wishlist is opened")
    @Override
    public boolean isElementDisplayed() {
        return waitForElementToBeDisplayed(myWishListText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Step("User clicks on my wishlists")
    public void clickMyWishlists() {
        myAccountComponent.getWishLists();
    }

    @Step("User clicks on wish-list products")
    public void clickWishlistProducts() {
        wishListComponent.getWishListProductsBtn();
    }

}
