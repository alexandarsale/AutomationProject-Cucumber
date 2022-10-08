package pages;

import components.SpecialsComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class PriceDropPage extends BasePage{

    @FindBy(xpath = "//h1[contains(text(),'Price drop')]")
    private WebElement priceDropText;

    private final SpecialsComponent specialsComponent;

    public PriceDropPage(WebDriver driver) {
        super(driver);
        specialsComponent = new SpecialsComponent(driver);
    }

    @Step("Asserting specials page is opened")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(priceDropText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    @Step("User clicks on the list-view button")
    public void clickListsBtn(){
        specialsComponent.getListsBtn();
    }

    @Step("User clicks on wish-list btn")
    public void clickWishBtn(){
        specialsComponent.getWishListBtn();
    }

    @Step("User clicks on wishlist btn of product")
    public void clickSecondWishBtn(){
        specialsComponent.getSecondWishListBtn();
    }

    @Step("User clicks on specials btn")
    public void clickOnSpecialsBtn(){
        specialsComponent.getSpecialsBtn();
    }

    @Step("User clicks on first item in the special's page")
    public void clickOnFistItemBtn(){
        specialsComponent.getFirstItem();
    }

    @Step("User clicks on second product in specials page")
    public void clickOnSecondItemBtn(){
        specialsComponent.getSecondItem();
    }

    @Step("User increases quantity of first special product")
    public void increaseFirstItem(){
        specialsComponent.increaseQuantityOfFirstProduct();
    }

    @Step("User increases quantity of second special product")
    public void increaseSecondItem(){
        specialsComponent.increaseQuantityOfSecondProduct();
    }
}
