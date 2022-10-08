package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountComponent extends BaseComponent {

    @FindBy(css = "a[title='My wishlists']")
    private WebElement myWishlists;

    public MyAccountComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getWishLists() {
        click(myWishlists);
    }
}
