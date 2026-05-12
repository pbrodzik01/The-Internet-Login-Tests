package config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                PROPERTIES.load(inputStream);
            }
        } catch (Exception exception) {
            throw new RuntimeException("Failed to load config.properties", exception);
        }
    }

    private ConfigReader() {
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url", "https://the-internet.herokuapp.com");
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(PROPERTIES.getProperty("headless", "false"));
    }

    public static int getTimeoutSeconds() {
        return Integer.parseInt(PROPERTIES.getProperty("timeout.seconds", "10"));
    }
}