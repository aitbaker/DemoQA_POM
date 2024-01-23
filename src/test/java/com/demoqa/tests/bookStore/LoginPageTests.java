package com.demoqa.tests.bookStore;

import com.demoqa.data.UserData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStoreApplication();
        new SidePanel(driver).selectLogin();
    }

    @Test(enabled = false)
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login(UserData.USER_NAME,UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);
    }

    @Test
    @Parameters({"name","password"})
    public void loginPositiveWithParametersTest(String name, String password) {
        new LoginPage(driver)
                .login(name,password)
                .assertAccount(name);
    }
}
