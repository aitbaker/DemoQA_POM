package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(id = "toolTipButton")
        WebElement toolTipBtn;

        @FindBy(id = "buttonToolTip")
        WebElement toolTip;

        public ToolTipsPage hoverToolTipsWithAttribute() {
            pause(1000);
            click(toolTipBtn);

            String expectedTooltip = toolTip.getAttribute("id");

            System.out.println("Retrived tooltit as: " + expectedTooltip);

            return this;
        }

        @FindBy(id = "toolTipTextField")
        WebElement hoverMeToSee;

        @FindBy(id = "textFieldToolTip")
        WebElement textFieldToolTip;

        public ToolTipsPage hoverOnInputToSee() {
            pause(1000);
            moveWithJSExecutor(0,100);

            new Actions(driver).moveToElement(hoverMeToSee).perform();

            String expectedToolTipText = textFieldToolTip.getText();

            System.out.println("ToolTipText --> " + expectedToolTipText);

            if (expectedToolTipText.equalsIgnoreCase("You hovered over the text field")){
                System.out.println("PASS: Tooltip is matching expected value");
            }else {
                System.out.println("FAIL: Tooltip is NOT matching expected value");
            }
            return this;
        }
}
