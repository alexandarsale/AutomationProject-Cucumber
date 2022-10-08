package Utils;

import Exceptions.InvalidFilePathException;
import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    private static Properties properties = new Properties();

    static {
        FileInputStream fs;
        try {
            fs = new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(ConfigProperties key) {
        String value;
        value = properties.getProperty(key.name().toLowerCase());
        if (Objects.isNull(value)) {
            throw new InvalidFilePathException("Property name " + key + " is not found. Please check config.properties");
        }
        return value;
    }
}
