package com.demoqa.tests.elements;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.UploadAndDownLoadPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.Test;

import java.awt.*;

public class RobotTests extends TestBase {

    @Test
    public void robotKeyEventsTests() throws AWTException {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUploadAndDownload().hideIframes();
        new UploadAndDownLoadPage(driver).performKeyEventUsingRobot().getPath().contains("D1.txt.");
    }

    @Test
    public void robotMouseEventsTests() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUploadAndDownload().hideIframes();
        new UploadAndDownLoadPage(driver).performMouseEventUsingRobot();
    }
}
