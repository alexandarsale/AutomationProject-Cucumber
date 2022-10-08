package components;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class Randomizer {

    private WebDriver driver;

    public String emailRandomizer() {
        return RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
    }

    public String firstNameRandomizer() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String lastNameRandomizer() {
        return RandomStringUtils.randomAlphabetic(9);
    }
}
