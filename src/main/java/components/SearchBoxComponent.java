package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBoxComponent extends BaseComponent {

    @FindBy(css = "#search_query_top")
    private WebElement searchBox;

    @FindBy(css = "button[name='submit_search']")
    private WebElement searchBtn;

    public SearchBoxComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void enterTextInSearchField(String search) {
        sendKeys(searchBox, search);
    }

    public void clickOnSearchBtn() {
        click(searchBtn);
    }
}