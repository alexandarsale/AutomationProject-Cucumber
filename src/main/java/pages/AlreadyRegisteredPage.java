package pages;

import components.SignInComponent;
import io.qameta.allure.Step;
import model.LoginAcc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static model.LoginAcc.*;
import static waiter.Waiter.PAGE_LOAD_TIMEOUT;
import static waiter.Waiter.waitForElementToBeDisplayed;

public class AlreadyRegisteredPage extends BasePage {

    private final SignInComponent signInComponent;
    private final Map<LoginAcc, String> login;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    private WebElement signInText;

    public AlreadyRegisteredPage(WebDriver driver) {
        super(driver);
        signInComponent = new SignInComponent(driver);
        login = getCredentials();
    }

    @Step("Asserting log in page is opened")
    @Override
    public boolean isOpened() {
        return waitForElementToBeDisplayed(signInText, driver, PAGE_LOAD_TIMEOUT);
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Override
    protected boolean isElementDisplayed() {
        return false;
    }

    @Step("User enters valid credentials and completes the sign in process")
    public void setLogInData() {
        signInComponent.validEmail(login.get(Email));
        signInComponent.validPassword(login.get(Password));
        clickLogInButton();
    }

    private void clickLogInButton() {
        signInComponent.clickSignInButton();
    }
}
