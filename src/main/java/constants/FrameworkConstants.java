package constants;

public class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/java/resources/config/config.properties";
    private static final int WAITTIMEINSECONDS = 10;

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
    public static int getWaitTimeInSeconds(){return WAITTIMEINSECONDS;}
}
