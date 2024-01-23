package com.demoqa.tests.alertFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new WindowsPage(driver).switchToNewTab(1).assertNewTabByMessage("This is a sample page");
    }
}
