package com.demoqa.tests.elements;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksAndImagesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkAllUrl();
    }

    @Test
    public void checkBrokenLinksTest() {
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImagesPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new SidePanel(driver).selectBrokenLinks();
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}
