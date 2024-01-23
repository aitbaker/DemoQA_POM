package com.demoqa.pages.interactions;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortablePage extends BasePage {

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "demo-tabpane-list")
    WebElement table;

    public SortablePage chooseOnTheList() {
        System.out.println(table.getText());

//        Eyes eyes = new Eyes();
//        eyes.open(driver,"Sortable","List");
//        eyes.checkWindow();
//        eyes.close();

        return this;
    }

    public SortablePage sortable() {
//        String expectedTableValues = """
//                One
//                Two
//                Three
//                Four
//                Five
//                Six""";
//
//        Assert.assertEquals(expectedTableValues, table.getText());
        return this;
    }
}
