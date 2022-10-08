package stepDefinition;


import Utils.ReadPropertyFile;
import components.*;
import driver.Driver;
import driver.DriverManager;
import enums.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import productValidation.ValidateProduct;
import tests.BaseTest;

import static org.testng.Assert.assertTrue;


public class Steps extends BaseTest {

    // Login with Valid Credentials Test

    @Given("User Launch Chrome browser and open url")
    public void userLaunchChromeBrowserAndOpenUrl() {
        Driver.initDriver();
    }

    @When("User Clicks on SignIn")
    public void user_clicks_on_sign_in() {
        HomePage home = new HomePage(DriverManager.getDriver());
        assertTrue(home.isOpened());
        home.clickOnSignUpButton();
    }

    @When("User enters email as {string} and Password as {string} and clicks login")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        AlreadyRegisteredPage arPage = new AlreadyRegisteredPage(DriverManager.getDriver());
        arPage.setLogInData();
    }

    @Then("User checks if Login is successful")
    public void user_checks_if_login_is_successful() {
        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
        assertTrue(myAccountPage.isOpened());
    }

    @Then("close browser")
    public void close_browser() {
        Driver.quitDriver();
    }

    //Create new Account test

    @Then("User enters random email in create account text field")
    public void user_enters_random_email_in_create_account_text_field() {

        AuthenticationPage auPage = new AuthenticationPage(DriverManager.getDriver());
        auPage.enterRandomEmail();
        auPage.clickCreateAccButton();
    }

    @Then("User verifies valid email is entered")
    public void user_verifies_valid_email_is_entered() {

        CreateAccountPage createAccountPage = new CreateAccountPage(DriverManager.getDriver());
        assertTrue(createAccountPage.isOpened());
    }

    @Then("User enters personal data information")
    public void user_enters_personal_data_information() {

        CreateAccountPage createAccountPage = new CreateAccountPage(DriverManager.getDriver());
        //Enter Personal data
        createAccountPage.setPersonalData();
        /* Adding Company and Address information */
        createAccountPage.setAddressData();
    }

    @Then("User verifies if account is successfully created")
    public void user_verifies_if_account_is_successfully_created() {

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
        assertTrue(myAccountPage.isOpened());
    }

    //Make and Order Test

    @When("User clicks on T-Shirt section")
    public void user_clicks_on_t_shirt_section() {

        ShirtsPage shirtsPage = new ShirtsPage(DriverManager.getDriver());
        shirtsPage.clickOnTShirtButton();
    }

    @When("verifies T-Shirt section is opened")
    public void verifies_t_shirt_section_is_opened() {

        ShirtsPage shirtsPage = new ShirtsPage(DriverManager.getDriver());
        assertTrue(shirtsPage.isOpened());
    }

    @Then("User adds product to cart")
    public void user_adds_product_to_cart() {

        ShirtsPage shirtsPage = new ShirtsPage(DriverManager.getDriver());
        shirtsPage.hoverOverItemAndClickAddToCartButton();
    }

    @Then("User verifies if product is added to cart")
    public void user_verifies_if_product_is_added_to_cart() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        assertTrue(itemCheckOutPage.isOpened());
    }

    @Then("User finishes order")
    public void user_finishes_order() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        itemCheckOutPage.clickProceedCheckOutButton();
        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();
        assertTrue(itemCheckOutPage.isElementDisplayed());

        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickConfirmOrderBtn();

        //Assert that order is completed
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }

    @Then("User verifies order is completed successfully")
    public void user_verifies_order_is_completed_successfully() {

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }

    //Search Product and Add to Cart

    @When("User enters product name as {string} in search box")
    public void user_enters_product_name_as_in_search_box(String string) {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.setSearchBox(ReadPropertyFile.getValue(ConfigProperties.PRODUCT));

    }

    @Then("User clicks on Search button")
    public void user_clicks_on_search_button() {

        HomePage home = new HomePage(DriverManager.getDriver());
        home.setSearchBtn();
    }

    @Then("User clicks on list view of all products")
    public void user_clicks_on_list_view_of_all_products() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        priceDropPage.clickListsBtn();
    }

    @Then("User selects product between min and max price range")
    public void user_selects_product_between_min_and_max_price_range() {

        ProductListComponent productListComponent = new ProductListComponent(DriverManager.getDriver());
        productListComponent.getProductPrice(Double.parseDouble(ReadPropertyFile.getValue(ConfigProperties.MAXPRICE)),
                Double.parseDouble(ReadPropertyFile.getValue(ConfigProperties.MINPRICE)));
    }

    @When("User verifies if product by given price is added to cart")
    public void user_verifies_if_product_by_given_price_is_added_to_cart() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        assertTrue(itemCheckOutPage.isOpened());
        itemCheckOutPage.clickProceedCheckOutButton();
    }

    @When("User verifies every step of checkout page is opened successfully")
    public void user_verifies_every_step_of_checkout_page_is_opened_successfully() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());

        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();

        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickConfirmOrderBtn();
    }

    @Then("User confirms order is complete")
    public void user_confirms_order_is_complete() {

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }

    //Make Order With increased quantity

    @Then("User goes to checkout to increase quantity of product by {string} and finish order")
    public void user_goes_to_checkout_to_increase_quantity_of_product_by_and_finish_order(String string) {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());

        itemCheckOutPage.clickProceedCheckOutButton();
        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();

        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickSummaryStep();
        itemCheckOutPage.addQuantityBtn();

        //Assert that user is on checkout page menu and can finish the order
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();
        //Assert that user is on the right checkout page
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();
        //Assert that user can check shipping options
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();
        //Assert that user can choose payment option
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();

        itemCheckOutPage.clickConfirmOrderBtn();

        //Assert that order is completed
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }

    //Make Order As Guest

    @Then("User tries to purchase order")
    public void user_tries_to_purchase_order() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        itemCheckOutPage.clickProceedCheckOutButton();

        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();
    }
    @Then("User is asked to login to continue the purchase")
    public void user_gets_prompted_to_login_to_make_the_purchase() {

        AlreadyRegisteredPage arPage = new AlreadyRegisteredPage(DriverManager.getDriver());
        arPage.setLogInData();

    }
    @When("User is logged in continues to finish the order")
    public void user_is_logged_in_continues_to_finish_the_order() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        //Continue with checkout order
        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickConfirmOrderBtn();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());

        //Assert that order is completed
        assertTrue(orderConfirmationPage.isOpened());
    }

    // Add Specials to Cart

    @Then("User clicks on Specials button")
    public void user_clicks_on_specials_button() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        priceDropPage.clickOnSpecialsBtn();
    }
    @Then("User verifies Specials page is opened")
    public void user_verifies_specials_page_is_opened() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        assertTrue(priceDropPage.isOpened());
    }
    @Then("User adds first special product to cart")
    public void user_adds_first_special_product_to_cart() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        priceDropPage.clickOnFistItemBtn();
    }
    @Then("User adds second special product and purchase the order")
    public void user_purchase_the_order() {

        ItemCheckOutPage itemCheckOutPage = new ItemCheckOutPage(DriverManager.getDriver());
        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());

        itemCheckOutPage.clickContinueShoppingBtn();
        priceDropPage.clickOnSecondItemBtn();
        itemCheckOutPage.clickProceedCheckOutButton();
        priceDropPage.increaseFirstItem();
        priceDropPage.increaseSecondItem();

        //Assert that user is on checkout page menu and can finish the order
        SummaryComponent summaryComponent = new SummaryComponent(DriverManager.getDriver());
        assertTrue(summaryComponent.isElementDisplayed());
        itemCheckOutPage.clickProceedBtn();

        //Assert that user is on the right checkout page
        AddressCheckoutComponent addressCheckoutComponent = new AddressCheckoutComponent(DriverManager.getDriver());
        assertTrue(addressCheckoutComponent.isElementDisplayed());
        itemCheckOutPage.clickProcessBtn();

        //Assert that user can check shipping options
        ShippingComponent shippingComponent = new ShippingComponent(DriverManager.getDriver());
        assertTrue(shippingComponent.isElementDisplayed());
        itemCheckOutPage.checkTermsAndConditions();
        itemCheckOutPage.clickCarrierBtn();

        //Assert that user can choose payment option
        PaymentComponent paymentComponent = new PaymentComponent(DriverManager.getDriver());
        assertTrue(paymentComponent.isElementDisplayed());
        itemCheckOutPage.selectPaymentViaBank();
        itemCheckOutPage.clickConfirmOrderBtn();

        //Assert that order is completed
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(DriverManager.getDriver());
        assertTrue(orderConfirmationPage.isOpened());
    }

    //Add Products to WishList

    @Then("User adds first product to wishlist")
    public void user_adds_first_product_to_wishlist() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        priceDropPage.clickWishBtn();
    }
    @Then("User verifies pop-up message is displayed")
    public void user_verifies_pop_up_message_is_displayed() {

        QuickViewPage quickViewPage = new QuickViewPage(DriverManager.getDriver());
        assertTrue(quickViewPage.isOpened());
    }
    @Then("User closes pop-up message")
    public void user_closes_pop_up_message() {

        QuickViewPage quickViewPage = new QuickViewPage(DriverManager.getDriver());
        quickViewPage.clickCloseBtn();
    }
    @Then("User adds second product to wishlist")
    public void user_adds_second_product_to_wishlist() {

        PriceDropPage priceDropPage = new PriceDropPage(DriverManager.getDriver());
        priceDropPage.clickSecondWishBtn();
    }
    @Then("User opens account menu and clicks on My Wishlist")
    public void user_opens_account_menu_and_clicks_on_my_wishlist() {

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());
        navigationBarPage.clickAccountBtn();
        assertTrue(myAccountPage.isOpened());
        myAccountPage.clickMyWishlists();
    }
    @Then("User verifies my wishlist is opened")
    public void user_verifies_my_wishlist_is_opened() {

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
        assertTrue(myAccountPage.isElementDisplayed());
    }
    @Then("User clicks on wishlist products")
    public void user_clicks_on_wishlist_products() {

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
        myAccountPage.clickWishlistProducts();
    }
    @Then("User verifies that added products to wishlist are {string} and {string}")
    public void user_verifies_that_added_products_to_wishlist_are_and(String string, String string2) {

        ValidateProduct validateProduct = new ValidateProduct(DriverManager.getDriver());
        assertTrue(validateProduct.isTextPresent("Printed Chiffon Dress"));
        assertTrue(validateProduct.isTextPresent("Printed Summer Dress"));
    }

}
