package components;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SpecialsComponent extends BaseComponent {

    @FindBy(css = "a[title='All specials']")
    private WebElement allSpecialsBtn;

    @FindBy(css = "a.button[title='Add to cart']")
    private List<WebElement> addFirstItemBtn;

    @FindBy(css = "a.cart_quantity_up")
    private List<WebElement> increaseItems;

    @FindBy(css = "h5[itemprop = 'name'] > a[title='Printed Chiffon Dress']")
    public WebElement chiffonDressItem;

    @FindBy(css = "h5[itemprop = 'name'] > a[title='Printed Summer Dress']")
    public WebElement summerDressItem;

    @FindBy(css = "#list")
    private WebElement listsBtn;

    @FindBy(css = "a.addToWishlist")
    private List<WebElement> wishlistButton;

    public SpecialsComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getSpecialsBtn() {
        click(allSpecialsBtn);
    }

    public void getWishListBtn() {
        click(wishlistButton.get(0));
    }

    public void getSecondWishListBtn() {
        click(wishlistButton.get(1));
    }

    public void getListsBtn() {
        click(listsBtn);
    }

    public void getFirstItem() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(chiffonDressItem).perform();
        click(addFirstItemBtn.get(0));
    }

    public void getSecondItem() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(summerDressItem).perform();
        click(addFirstItemBtn.get(1));
    }

    public void increaseQuantityOfFirstProduct() {
        for (int i = 1; i <= 2; i++) {
            click(increaseItems.get(0));
        }
    }

    public void increaseQuantityOfSecondProduct() {
        for (int i = 1; i <= 2; i++) {
            click(increaseItems.get(1));
        }
    }
}
