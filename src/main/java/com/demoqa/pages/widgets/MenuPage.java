package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;

    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    WebElement subSubItem2;

    public MenuPage selectSubMenu() {
        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Mouse hover menuOption 'Main Item 2'
        actions.moveToElement(mainItem2).perform();
        System.out.println(mainItem2.getText());
        moveWithJSExecutor(0,100);
        //Mouse hover menuOption 'SUB SUB LIST »'
        actions.moveToElement(subSubList).perform();
        System.out.println(subSubList.getText());
        // moveWithJSExecutor(0,100);
        //Now Select 'Alternative' from sub menu which has got displayed on mouse hover of 'Rock'
//       actions.moveToElement(subSubItem2).perform();
//       actions.clickAndHold(subSubItem2).perform();
//       pause(2000);
        Assert.assertTrue(subSubItem2.isDisplayed());
        return this;
    }
}
