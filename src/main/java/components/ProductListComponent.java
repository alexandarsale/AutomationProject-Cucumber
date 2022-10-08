package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListComponent extends BaseComponent {

    @FindBy(xpath = "//div[@class='right-block-content row']/div[1]/span[1]")
    private List<WebElement> productPrice;

    @FindBy(css = "a[title='Add to cart']")
    private List<WebElement> addToCartBtnList;

    @FindBy(css = "span.ajax_block_products_total")
    private WebElement confirm;

    public ProductListComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    @Step("Get all product prices, if product matches min/max price range add it to cart")
    public void getProductPrice(double minPrice, double maxPrice) {
        for (int i = 0; i < productPrice.size(); i++) {
            String price = productPrice.get(i).getText();
            price = price.replaceAll("\\$", "");
            double pPrice = Double.parseDouble(price);
            if (pPrice < minPrice && pPrice > maxPrice) {
                click(addToCartBtnList.get(i));
            }
        }
    }
}
