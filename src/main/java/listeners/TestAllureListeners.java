package listeners;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


public class TestAllureListeners implements ITestListener {

    @Attachment(type = "image/png")
    public byte[] takeScreenshot() {
        WebDriver driver = DriverManager.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(type = "image/png")
    public void takeScreenshots() {
        WebDriver driver = DriverManager.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./failed_tests/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(type = "image/png")
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Executing listener on failure");
        takeScreenshots();
    }

/*

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void getScreenshot() throws IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
        File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("D:\\Practice\\AutomationPractice\\AutomationPractice\\target\\allure-results" + screenshotfilename + ".png"));
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", DriverManager.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

  @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

        ITestContext context = iTestResult.getTestContext();

        // Allure ScreenShot and SaveTestLog

            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
          //  saveScreenshotPNG(DriverManager.getDriver());
            try {
                getScreenshot();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }


   */
/* @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = DriverManager.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }


    *//*


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

*/

    //testRunner.TestRun
/*

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        System.out.println(result.getMethod().getMethodName() + " failed!");

        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");

        // attach screenshots to report
        //saveFailureScreenShot(DriverManager.getDriver());
        try {
            takeScreenshot(DriverManager.getDriver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Attachment
    private void takeScreenshot(WebDriver webDriver) throws IOException {
        File screenshotAs = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    }



    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

 */
}
