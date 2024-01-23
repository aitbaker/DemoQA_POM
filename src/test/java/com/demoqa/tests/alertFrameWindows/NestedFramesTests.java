package com.demoqa.tests.alertFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.NestedFramesPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectNestedFrames();
    }

    @Test
    public void handleNestedFramesTest() {
        new NestedFramesPage(driver).handleNestedFrames();
    }

    @Test
    public void switchToParentFramesTest() {
        new NestedFramesPage(driver).switchToParentFrames();
    }

    @Test
    public void switchToMainFramesTest() {
        new NestedFramesTests(driver).switchToMainPageFrames();
    }
}
