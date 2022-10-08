package pages;

import components.SearchBoxComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class HomePage extends BasePage {

    private final SearchBoxComponent searchBoxComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        searchBoxComponent = new SearchBoxComponent(driver);
    }

    //Sign up button element
    @FindBy(css = "a.login")
    private WebElement signUpButton;

    @FindBy(css = "a.login")
    private WebElement homePageLogo;

    @Step("Asserting that the user is on the Home Page as expected")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(homePageLogo, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    @Step("User clicks on sign up button")
    public void clickOnSignUpButton() {
        click(signUpButton);
    }

    @Step("User types a product in searchbox")
    public void setSearchBox(String product) {
        searchBoxComponent.enterTextInSearchField(product);
    }

    @Step("User clicks on search button")
    public void setSearchBtn() {
        searchBoxComponent.clickOnSearchBtn();
    }
}
