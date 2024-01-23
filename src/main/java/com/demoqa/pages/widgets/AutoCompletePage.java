package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoCompletePage extends BasePage {

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;

    @FindBy(css = ".auto-complete__menu.css-2613qy-menu")
    List<WebElement> multiselect;

    public AutoCompletePage autoComplete() {
        autoCompleteMultipleInput.sendKeys("a");
        autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }

    public AutoCompletePage autoComplete2() {
        Actions actions = new Actions(driver);
        actions.keyDown(autoCompleteMultipleInput, Keys.SHIFT);

        actions.sendKeys("Black");

        actions.keyUp(Keys.SHIFT);
        return this;
    }

    @FindBy(css = ".auto-complete__menu")
    List<WebElement> autoCompleteMenu;

    public AutoCompletePage autoComplete3(String color) {
        autoCompleteMultipleInput.sendKeys("a");
        for (WebElement options: autoCompleteMenu) {
            System.out.println(options.getText());
            if (options.getText().equals(color)){
                System.out.println(color);
                options.click();
            }
//            options.click();
        }
        return this;
    }
}
