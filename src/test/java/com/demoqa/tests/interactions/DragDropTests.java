package com.demoqa.tests.interactions;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }

    @Test
    public void actionDragMeTest() {
        new DroppablePage(driver).actionDragMe();
    }

    @Test
    public void dragAndDropByTest() {
        new DroppablePage(driver).dragAndDropBy(20,35);
    }
}
