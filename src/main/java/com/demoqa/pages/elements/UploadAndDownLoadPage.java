package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadAndDownLoadPage extends BasePage {

    public UploadAndDownLoadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='uploadFile']")
    WebElement uploadFile;

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadAndDownLoadPage performKeyEventUsingRobot() throws AWTException {
        pause(1000);
        //click uploadFile button
        org.openqa.selenium.Rectangle rect = uploadFile.getRect();

        int offSetX = rect.getWidth() / 12;
        int offSetY = rect.getHeight() / 3;

        Actions actions = new Actions(driver);
        actions.moveToElement(uploadFile).perform();
        actions.moveByOffset(-offSetX, -offSetY).click().perform();

        //Create object of Robot class
        Robot robot = new Robot();
        //Code to Enter D1.txt
        //Press Shift key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        //Press d, it gets typed as upper case D as Shift key is pressed
        robot.keyPress(KeyEvent.VK_D);
        //Release SHIFT key to release upper case effect
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);

        //Press ENTER to close the popup
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

    public String getPath() {
        return uploadedFilePath.getText();
    }

    public UploadAndDownLoadPage performMouseEventUsingRobot() {
        pause(1000);

        //click uploadFile button
        org.openqa.selenium.Rectangle rect = uploadFile.getRect();

        int offSetX = rect.getWidth() / 12;
        int offSetY = rect.getHeight() / 3;

        Actions actions = new Actions(driver);
        actions.moveToElement(uploadFile).release().build().perform();
        actions.moveByOffset(-offSetX, -offSetY).click().perform();

        //Create object of Robot class

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //Find x and y coordinates to pass to mouseMove method
        //1. Get the size of the current window.
        //2. Dimension class is similar to java Point class which represents a location in a two-dimensional (x, y) coordinate space.
        //But here Point point = element.getLocation() method can't be used to find the position
        //as this is Windows Popup and its locator is not identifiable using browser developer tool
        Dimension i = driver.manage().window().getSize();
        System.out.println("Dimension x and y :" + i.getWidth() + " " + i.getHeight());
        //3. Get the height and width of the screen
        int x = (i.getWidth() / 4) + 900;
        int y = (i.getHeight() / 10) + 250;
        //4. Now, adjust the x and y coordinates with reference to the Windows popup size on the screen
        //e.g. On current screen , Windows popup displays on almost 1/4th of the screen . So with reference to the same, file name x and y position is specified.
        //Note : Please note that coordinates calculated in this sample i.e. x and y may vary as per the screen resolution settings
        robot.mouseMove(x, y);
        pause(2000);
        //Clicks Left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("Browse button clicked");
        pause(10000);

        //Closes the Desktop Windows popup
        robot.keyPress(KeyEvent.VK_ENTER);
        System.out.println("Closed the windows popup");
        pause(2000);
        return this;
    }
}
