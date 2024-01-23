package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement slider;

    @FindBy(css = "[value]")
    WebElement sliderValue;

    public SliderPage moveSliderInHorizontalDirections() {

        Actions actions = new Actions(driver);
        pause(1000);
        //Move mouse to x offset 210 i.e. in horizontal direction
        actions.dragAndDropBy(slider,210,0).perform();
        String value = sliderValue.getAttribute("value");
        System.out.println(value);
        Assert.assertEquals(getValueAttribute(sliderValue,"value"),"100");
        return this;
    }

    public String getValueAttribute(WebElement element, String name) {
        return element.getAttribute(name);
    }
}
