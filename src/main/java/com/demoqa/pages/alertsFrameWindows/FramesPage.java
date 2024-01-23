package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    public FramesPage getListOfFrames() {

        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //By finding all the web elements using iframe tag

        System.out.println("The total number of iframes are " + frames.size());
        return this;
    }

    public FramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    public FramesPage switchToFrameByID() {
        driver.switchTo().frame("frame1");
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "sampleHeading")
    WebElement frame;

    public FramesPage getTextFromFrame() {
        //Finding the text of the frame1 heading
        driver.switchTo().frame(frame1);
        //Finding the text of the frame1 heading
        String frame1Text = frame.getText();
        //Print the heading
        System.out.println("Text of the frame1 heading is: " + frame1Text);
        return this;
    }
}
