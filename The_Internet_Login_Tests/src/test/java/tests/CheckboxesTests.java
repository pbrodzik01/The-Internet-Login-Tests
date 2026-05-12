package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

public class CheckboxesTests extends BaseTest {

    @Test
    void shouldCheckFirstCheckbox() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);

        checkboxesPage
                .open()
                .setCheckbox1(true);

        Assertions.assertTrue(checkboxesPage.isCheckbox1Checked());
        Assertions.assertTrue(checkboxesPage.isCheckbox2Checked());
    }
}