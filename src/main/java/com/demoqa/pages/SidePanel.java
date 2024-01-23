package com.demoqa.pages;

import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.pages.alertsFrameWindows.NestedFramesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.bookStore.ProfilePage;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.UploadAndDownLoadPage;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.interactions.DroppablePage;
import com.demoqa.pages.interactions.SortablePage;
import com.demoqa.pages.widgets.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJSExecutor(login,0,600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alerts,0,300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public WindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindows,0,300);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage selectSelectMenu() {
        clickWithJSExecutor(selectMenu,0,600);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        clickWithJSExecutor(droppable,0,600);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profile;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile, 0, 500);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public JSExecutor selectTextBox() {
        click(textBox);
        return new JSExecutor(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public LinksPage selectLinks() {
        clickWithJSExecutor(links,0,400);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinks() {
        clickWithJSExecutor(brokenLinksImages,0,400);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        clickWithJSExecutor(toolTips,0,700);
        return new ToolTipsPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,500);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Sortable']")
    WebElement sortable;

    public SortablePage selectSortable() {
        clickWithJSExecutor(sortable,0,500);
        return new SortablePage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrame() {
        clickWithJSExecutor(frames,0,500);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames,0,500);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Accordian']")
    WebElement accordion;

    public AccordianPage selectAccordion() {
        clickWithJSExecutor(accordion,0,500);
        return new AccordianPage(driver);
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutocomplete() {
        clickWithJSExecutor(autoComplete,0,500);
        return new AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage selectMenuPage() {
        clickWithJSExecutor(menu,0,500);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSliderPage() {
        clickWithJSExecutor(slider,0,500);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//li[@id='item-7']/span")
    WebElement uploadAndDownload;

    public UploadAndDownLoadPage selectUploadAndDownload() {
        clickWithJSExecutor(uploadAndDownload,0,500);
        return new UploadAndDownLoadPage(driver);
    }
}