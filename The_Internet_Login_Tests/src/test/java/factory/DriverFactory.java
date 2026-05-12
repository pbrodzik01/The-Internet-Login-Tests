package factory;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", ConfigReader.getBrowser()).toLowerCase();
        boolean headless = Boolean.parseBoolean(
                System.getProperty("headless", String.valueOf(ConfigReader.isHeadless()))
        );

        if (!browser.equals("chrome")) {
            throw new IllegalArgumentException("Currently supported browser: chrome");
        }

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        return new ChromeDriver(options);
    }
}