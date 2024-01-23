package com.demoqa.tests.alertFrameWindows;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgets();

    }

    @Test
    public void menuTest() {
        new SidePanel(driver).selectMenuPage();
        new MenuPage(driver).selectSubMenu();
    }

    @Test
    public void sliderTest() {
        new SidePanel(driver).selectSliderPage();
        new SliderPage(driver).moveSliderInHorizontalDirections();
    }
}
