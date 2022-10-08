package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationComponent extends BaseComponent {

    @FindBy(css = "#id_gender1")
    private WebElement gender;

    @FindBy(css = "#customer_firstname")
    private WebElement first_name;

    @FindBy(css = "#customer_lastname")
    private WebElement last_name;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(css = "#days")
    private WebElement days;

    @FindBy(css = "#months")
    private WebElement months;

    @FindBy(css = "#years")
    private WebElement years;

    @FindBy(css = "#newsletter")
    private WebElement newsletter_checkbox;

    @FindBy(css = "#optin")
    private WebElement specialOffer_checkbox;

    public PersonalInformationComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void selectGender() {
        click(gender);
    }

    public void setFirsName(String firsName) {
        sendKeys(first_name, firsName);
    }

    public void setLastName(String lastName) {
        sendKeys(last_name, lastName);
    }

    public void setPassword(String pswd) {
        sendKeys(password, pswd);
    }

    public void setDay(String day) {
        selectDropDown(days, day);
    }

    public void setMonth(String month) {
        selectDropDown(months, month);
    }

    public void setYear(String year) {
        selectDropDown(years, year);
    }

    public void clickNewsletterBox() {
        click(newsletter_checkbox);
    }

    public void clickSpecialOfferBox() {
        click(specialOffer_checkbox);
    }
}
