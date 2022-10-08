package tests;

import driver.DriverManager;
import io.qameta.allure.*;
import listeners.TestAllureListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AlreadyRegisteredPage;
import pages.HomePage;
import pages.MyAccountPage;

import static org.testng.Assert.assertTrue;
@Listeners(TestAllureListeners.class)
public class SignInWithValidCredentialsTest extends BaseTest {
    @Description("This test helps us to validate if the login is successful")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test verify login functionality")
    @Test(description = "SignIn with valid credentials")
    public static void signInTest() {

        HomePage home = new HomePage(DriverManager.getDriver());

        //Assert home page is opened and click signIn btn
        assertTrue(home.isOpened());

        home.clickOnSignUpButton();

        AlreadyRegisteredPage arPage = new AlreadyRegisteredPage(DriverManager.getDriver());

        //Assert login page is opened and log in with valid credentials
        assertTrue(arPage.isOpened());

        arPage.setLogInData();

        MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());

        //Assert login is successful
        assertTrue(myAccountPage.isOpened());
    }
}
