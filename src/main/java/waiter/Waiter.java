package waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);

    public static boolean waitForElementToBeDisplayed(WebElement element, WebDriver driver, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        ExpectedCondition<Boolean> elementIsDisplayed = arg0 -> element.isDisplayed();
        try {
            wait.until(elementIsDisplayed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
