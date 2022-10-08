package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderStepsComponent extends BaseComponent {

    //This locator is if we want to go back on our order to the beginning
    @FindBy(css = "li.step_done.first > a")
    private WebElement summaryStep;

    public OrderStepsComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getSummaryStep() {
        click(summaryStep);
    }
}
