package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButon;

    public ButtonsPage doubleClick() {
        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickButon).perform();
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        Actions actions = new Actions(driver);

        actions.contextClick(rightClickBtn).perform();
        return this;
    }
}
