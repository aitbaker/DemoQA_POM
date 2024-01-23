package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text!=null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .textToBePresentInElement(element,text));
    }

    public void clickWithJSExecutor(WebElement element,int x, int y) {
        js.executeScript("window.scrollBy(" + x +"," + y + ")");
        element.click();
    }

    public void typeWithJSExecutor(WebElement element, String text,int x,int y) {
        if (text!=null) {
            clickWithJSExecutor(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideAd() {
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");

    }

    public void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");

    }

    public void hideIframes() {
        hideAd();
        hideFooter();
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }

    public void clickWithRectangle(WebElement element, int x, int y) {

        Rectangle rectangle = element.getRect();

        int xOffset = rectangle.getWidth() / x;
        int yOffset = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffset).click().perform();
    }

    public void moveWithJSExecutor(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }
}
