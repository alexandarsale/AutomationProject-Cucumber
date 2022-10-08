package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListComponent extends BaseComponent {

    @FindBy(xpath = "//a[contains(text(),'My wishlist')]")
    private WebElement wishlistProductsBtn;

    @FindBy(css = "ul.row")
    private List<WebElement> boughtProducts;

    public WishListComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getWishListProductsBtn() {
        click(wishlistProductsBtn);
    }

}
