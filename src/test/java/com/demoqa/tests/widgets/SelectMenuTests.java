package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Blue");
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(driver).multiSelect("Red");
    }

    @Test
    public void multiSelectTest2() {
        new SelectMenuPage(driver).multiSelect2(new String[]{"Red","Blue","Green"});
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).standardMultiSelect(1);

    }

}
