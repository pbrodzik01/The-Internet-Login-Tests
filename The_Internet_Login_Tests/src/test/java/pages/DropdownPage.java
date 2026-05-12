package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage open() {
        openPath("/dropdown");
        return this;
    }

    public DropdownPage selectByVisibleText(String text) {
        Select select = new Select(waitForVisible(dropdown));
        select.selectByVisibleText(text);
        return this;
    }

    public String getSelectedOptionText() {
        Select select = new Select(waitForVisible(dropdown));
        return select.getFirstSelectedOption().getText().trim();
    }
}