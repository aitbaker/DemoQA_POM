package com.demoqa.tests.bookStore;

import com.demoqa.data.BookData;
import com.demoqa.data.UserData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookStore.BookStorePage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.bookStore.ProfilePage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).getBookStore();
        new LoginPage(driver).getLogin();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookToCollectionPositiveTest() {
        new BookStorePage(driver).typeInSearchField(BookData.BOOK_NAME)
                .clickByFirstBook()
                .addToYourCollection();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).assertNameOfBook("Git Pocket Guide");

    }

    @AfterMethod
    public void postConditions() {
        new ProfilePage(driver).clickOnTrashToDeleteBook();
    }
}
