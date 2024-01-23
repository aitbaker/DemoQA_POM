package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccordianPage extends BasePage {

    public AccordianPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "section2Heading")
    WebElement section2Heading;

    @FindBy(css = "#section2Content > p:nth-child(1)")
    WebElement section2Content;

    public AccordianPage scrollWithJS() {
        ((JavascriptExecutor)driver).executeScript("scroll(0, 200)");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(section2Heading)).click();
        System.out.println(new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(section2Content)).getText());
        return this;
    }
}
