package com.demoqa.tests.alertFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).clickByAlertWithTimer();
    }

    @Test
    public void alertWithSelectTest() {

        new AlertsPage(driver).selectConfirm("Cancel").assertResult("Cancel");
    }

    @Test
    public void sendTextToAlert() {
        new AlertsPage(driver).sendMessageToAlert("Hello World!").assertMessage("Hello World!");
    }
}
