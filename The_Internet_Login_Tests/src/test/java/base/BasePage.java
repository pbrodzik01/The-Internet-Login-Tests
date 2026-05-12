package base;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeoutSeconds()));
    }

    protected void openPath(String path) {
        driver.get(ConfigReader.getBaseUrl() + path);
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText().trim();
    }

    protected String getFlashMessageText(By locator) {
        String rawText = getText(locator);
        return rawText.split("\n")[0].trim();
    }

    protected boolean isChecked(By locator) {
        return waitForVisible(locator).isSelected();
    }

    protected void setCheckboxState(By locator, boolean shouldBeChecked) {
        if (isChecked(locator) != shouldBeChecked) {
            click(locator);
        }
    }

    protected void waitForUrlToContain(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }
}