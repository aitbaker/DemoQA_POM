package com.demoqa.tests.interactions;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.SortablePage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectSortable().hideIframes();
    }

    @Test
    public void sortableTest() {
        new SortablePage(driver).chooseOnTheList();
    }

    @Test
    public void sortableTest2() {
        new SortablePage(driver).sortable();
    }
}
