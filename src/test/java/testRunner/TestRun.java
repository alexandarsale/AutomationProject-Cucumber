package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions
        (
                features = "src/test/java/Features/",
                glue = "stepDefinition",
                dryRun = true,
                plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                }
        )
public class TestRun extends AbstractTestNGCucumberTests {
}
