package pages;

import components.NavigatioBarComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage {

    private final NavigatioBarComponent navigatioBarComponent;

    public NavigationBarPage(WebDriver driver) {
        super(driver);
        navigatioBarComponent = new NavigatioBarComponent(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    @Override
    public boolean isTextPresent(String text) {
        return false;
    }

    @Step("User clicks on account btn")
    public void clickAccountBtn() {
        navigatioBarComponent.getAccountBtn();
    }
}
