package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames() {
        int countIframesInPage = iframe.size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Get the text for frame1 element
        String frame1Text = body.getText();
        System.out.println("Frame1 is: " + frame1Text);

        //Number of Frames on a Frame1
        int countIframesInFrame1 = iframe.size();
        System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);

        //switch to child frame
        driver.switchTo().frame(0);

        String frame2Text = body.getText();
        System.out.println("Frame2 is: " + frame2Text);

        int countIframesInFrame2 = iframe.size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);
        return this;
    }

    public NestedFramesPage switchToParentFrames() {
        //Number of Frames on a Page
        int countIframesInPage = iframe.size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Number of Frames on a Frame1
        int countIframesInFrame1 = iframe.size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame1);

        //Switch to child frame
        driver.switchTo().frame(0);

        int countIframesInFrame2 = iframe.size();
        System.out.println("Number of Frames inside the Frame2:" + countIframesInFrame2);

        //Switch to Parent iFrame
        driver.switchTo().parentFrame();

        //Get the text for frame1 element
        String frame1Text = body.getText();

        //Try to Print the text present inside parent frame
        System.out.println("Frame1 is :" + frame1Text);
        return this;
    }

    @FindBy(xpath = "//div[@class='main-header']")
    WebElement mainHeader;

    @FindBy(tagName = "p")
    WebElement p;

    @FindBy(id = "framesWrapper")
    WebElement mainPageText;

    public NestedFramesPage switchToMainPageFrames() {

        //Find text of the page heading
        String pageHeading = mainHeader.getText();

        //Print the page heading
        System.out.println("Page Heading is: " + pageHeading);

        //Switch to Parent iframe
        driver.switchTo().frame(frame1);
        String frame1Text = body.getText();
        System.out.println("Frame1 is: " + frame1Text);

        //Switch to child frame
        driver.switchTo().frame(0);
        String frame2Text = p.getText();
        System.out.println("Frame2 is: " + frame2Text);

        //Switch to default content
        driver.switchTo().defaultContent();

        //Try to print the heading of the main page without switching

        System.out.println(mainPageText.getText());
        return this;
    }
}
