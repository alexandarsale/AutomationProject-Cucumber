package driver;

import Utils.ReadPropertyFile;
import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class Driver {

    public Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/resources/chrome-driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.HOMEPAGEURL));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
