package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatioBarComponent extends BaseComponent {

    @FindBy(css = "a.account")
    private WebElement accountBtn;

    public NavigatioBarComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getAccountBtn() {
        click(accountBtn);
    }
}
