package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected abstract boolean isOpened();

    protected abstract boolean isTextPresent(String text);

    protected boolean isElementDisplayed() {
        return false;
    }

}
