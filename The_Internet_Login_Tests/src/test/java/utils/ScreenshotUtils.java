package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static void saveScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return;
        }

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            Path screenshotsDir = Path.of("target", "screenshots");
            Files.createDirectories(screenshotsDir);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String safeTestName = testName.replaceAll("[^a-zA-Z0-9-_]", "_");

            Path filePath = screenshotsDir.resolve(timestamp + "_" + safeTestName + ".png");
            Files.write(filePath, screenshot);

        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}