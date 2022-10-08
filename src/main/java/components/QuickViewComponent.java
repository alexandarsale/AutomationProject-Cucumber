package components;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QuickViewComponent extends BaseComponent {

    private final SpecialsComponent specialsComponent;

    @FindBy(css = "a.quick-view")
    private List<WebElement> quickViewBtn;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    private WebElement wishListBtn;

    @FindBy(css = "a[title='Close']")
    private WebElement closeQuickViewBtn;

    @FindBy(css = "button[name='Submit']")
    private WebElement addToCart;

    @FindBy(css = "span.continue")
    private WebElement continueBtn;

    public QuickViewComponent(WebDriver driver) {
        super(driver);
        specialsComponent = new SpecialsComponent(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void getQuickViewBtn() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(specialsComponent.chiffonDressItem).perform();
        click(quickViewBtn.get(0));
    }

    public void getContinue() {
        DriverManager.getDriver().switchTo().defaultContent();
        click(continueBtn);
    }

    public void getMoreBtn() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(specialsComponent.summerDressItem).perform();
        click(specialsComponent.summerDressItem);
    }

    public void getWishListBtn() {
        DriverManager.getDriver().switchTo().frame(0);
        click(wishListBtn);
    }

    public void getWishList() {
        DriverManager.getDriver().switchTo().defaultContent();
        click(wishListBtn);
    }

    public void getCloseBtn() {
        click(closeQuickViewBtn);
    }
}
