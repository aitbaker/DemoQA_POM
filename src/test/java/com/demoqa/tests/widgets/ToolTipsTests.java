package com.demoqa.tests.widgets;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.ToolTipsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase {

    HomePage home;
    SidePanel sidePanel;
    ToolTipsPage toolTips;

    @BeforeMethod
    public void init() {
        home = new HomePage(driver);
        sidePanel = new SidePanel(driver);
        toolTips = new ToolTipsPage(driver);
        home.getWidgets();
        sidePanel.selectToolTips();
    }

    @Test
    public void hoverToolTipsWithAttributeTest() {
        toolTips.hoverToolTipsWithAttribute();
    }

    @Test
    public void toolTipsWithTextTest() {
        toolTips.hoverOnInputToSee();
    }
}
