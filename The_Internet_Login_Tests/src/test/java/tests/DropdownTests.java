package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

public class DropdownTests extends BaseTest {

    @Test
    void shouldSelectOption2FromDropdown() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage
                .open()
                .selectByVisibleText("Option 2");

        Assertions.assertEquals("Option 2", dropdownPage.getSelectedOptionText());
    }
}