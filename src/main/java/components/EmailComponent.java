package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailComponent extends BaseComponent {

    @FindBy(css = "#email_create")
    private WebElement create_acc_email;

    public EmailComponent(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void enterEmail(String email) {
        sendKeys(create_acc_email, email);
    }
}
