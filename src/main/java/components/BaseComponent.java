package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BaseComponent {

    protected WebDriver driver;

    protected BaseComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void selectDropDown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    protected abstract boolean isElementDisplayed();
}
