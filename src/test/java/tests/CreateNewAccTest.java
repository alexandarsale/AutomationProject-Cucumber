package tests;

import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.TestAllureListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

import static org.testng.Assert.assertTrue;
@Listeners({TestAllureListeners.class})
public class CreateNewAccTest extends BaseTest {
    @Description("Asserting that the user can create a new account with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Creating account")
    @Test(description = "Creating a new account with valid credentials")
    public static void signUpTest() {

        HomePage home = new HomePage(DriverManager.getDriver());

        //Assert home page is opened and click signIn btn
        assertTrue(home.isOpened());

        home.clickOnSignUpButton();

        AuthenticationPage auPage = new AuthenticationPage(DriverManager.getDriver());

        //Assert AuthenticationPage is opened, enter email for signUp and click CreateBtn
        assertTrue(auPage.isOpened());

        auPage.enterRandomEmail();

        auPage.clickCreateAccButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(DriverManager.getDriver());

        //Assert CreateAccountPage is opened
        assertTrue(createAccountPage.isOpened());

        //Enter Personal data
        createAccountPage.setPersonalData();

        /* Adding Company and Address information */
        createAccountPage.setAddressData();

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());

        //Assert that u have successfully created a new acc
        assertTrue(myAccountPage.isOpened());

    }
}
