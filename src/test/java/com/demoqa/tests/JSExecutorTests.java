package com.demoqa.tests;

import com.demoqa.data.UserData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JSExecutor;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.AccordianPage;
import com.demoqa.pages.widgets.AutoCompletePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();
    }

    @Test
    public void executorTest() {
        new JSExecutor(driver).enterDataWithJS(UserData.USER_NAME,
                        UserData.USER_EMAIL).clickOnSubmitWithJS().
                checkInnerTextWithJS().refreshWithJS().checkURLWithJS().checkTitleOfPageWithJS();
    }

    @Test
    public void openAccordionTest() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAccordion();
        new AccordianPage(driver).scrollWithJS();
    }

    @Test
    public void autoCompleteTest() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutocomplete();
        new AutoCompletePage(driver).autoComplete();
    }

    @Test
    public void autoComplete2Test() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutocomplete();
        new AutoCompletePage(driver).autoComplete2();
    }

    @Test
    public void autoComplete3Test() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutocomplete();
        new AutoCompletePage(driver).autoComplete3("Black");
    }
}
