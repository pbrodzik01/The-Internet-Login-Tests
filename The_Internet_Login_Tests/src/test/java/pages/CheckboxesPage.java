package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends BasePage {

    private final By checkbox1 = By.xpath("(//*[@id='checkboxes']/input)[1]");
    private final By checkbox2 = By.xpath("(//*[@id='checkboxes']/input)[2]");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckboxesPage open() {
        openPath("/checkboxes");
        return this;
    }

    public CheckboxesPage setCheckbox1(boolean shouldBeChecked) {
        setCheckboxState(checkbox1, shouldBeChecked);
        return this;
    }

    public CheckboxesPage setCheckbox2(boolean shouldBeChecked) {
        setCheckboxState(checkbox2, shouldBeChecked);
        return this;
    }

    public boolean isCheckbox1Checked() {
        return isChecked(checkbox1);
    }

    public boolean isCheckbox2Checked() {
        return isChecked(checkbox2);
    }
}