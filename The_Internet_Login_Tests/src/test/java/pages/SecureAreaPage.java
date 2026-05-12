package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private final By flashMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a[href='/logout']");
    private final By pageHeader = By.cssSelector("div.example h2");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage() {
        waitForUrlToContain("/secure");
        return getFlashMessageText(flashMessage);
    }

    public String getHeaderText() {
        return getText(pageHeader);
    }

    public boolean isOpened() {
        waitForUrlToContain("/secure");
        return driver.getCurrentUrl().contains("/secure");
    }

    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(driver);
    }
}