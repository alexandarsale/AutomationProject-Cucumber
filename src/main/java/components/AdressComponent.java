package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdressComponent extends BaseComponent {

    @FindBy(css = "#company")
    private WebElement company;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#id_state")
    private WebElement state;

    @FindBy(css = "#postcode")
    private WebElement zipCode;

    @FindBy(css = "#id_country")
    private WebElement country;

    @FindBy(css = "#phone_mobile")
    private WebElement phoneNumber;

    @FindBy(css = "#submitAccount")
    private WebElement registerButton;

    public AdressComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        return false;
    }

    public void enterCompany(String comp) {
        sendKeys(company, comp);
    }

    public void enterAddress(String add) {
        sendKeys(address, add);
    }

    public void enterCity(String citys) {
        sendKeys(city, citys);
    }

    public void selectState(String states) {
        selectDropDown(state, states);
    }

    public void enterPostalCode(String postCode) {
        sendKeys(zipCode, postCode);
    }

    public void selectCountry(String countrys) {
        selectDropDown(country, countrys);
    }

    public void enterPhoneNumber(String number) {
        sendKeys(phoneNumber, number);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }
}
