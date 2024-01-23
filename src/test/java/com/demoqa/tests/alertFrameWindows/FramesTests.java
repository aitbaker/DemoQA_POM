package com.demoqa.tests.alertFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectFrame();
    }

    @Test
    public void getListOfFramesTest() {
        new FramesPage(driver).getListOfFrames();
    }

    @Test
    public void switchToFrameByIndexTest() {
        new FramesPage(driver).switchToFrameByIndex(1);
    }

    @Test
    public void switchToFrameByIDTest() {
        new FramesPage(driver).switchToFrameByID();
    }

    @Test
    public void getTextFromFrameTest() {
        new FramesPage(driver).getTextFromFrame();
    }
}
