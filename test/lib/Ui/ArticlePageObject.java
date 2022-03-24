package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "//*[@text='Java (programming language)']",
        TITLE_APPIUM = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']",
        TITLE_APPIUM_PRESENT = "//*[@class='android.view.View']//*[@text='Appium']",
        FOOTER_ELEMENT = "//*[@text='View article in browser']",
        SAVE_BUTTON = "//*[@resource-id='org.wikipedia:id/article_menu_bookmark'][@text='Save']",
        ADD_TO_LIST_BUTTON = "//android.widget.Button[@text='ADD TO LIST']",
        OK_BUTTON = "//*[@resource-id='android:id/button1'][@text='OK']",
        INPUT_FIELD = "//android.widget.EditText[@text='Name of this list']";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(
                By.xpath(TITLE),
                "Cannot find article title on page!",
                15
        );
    }

    public WebElement waitForTitleAppiumElementAndClick()
    {
        return this.waitForElementAndClick(
                By.xpath(TITLE_APPIUM),
                "Cannot find article title on page!",
                15
        );
    }

    public WebElement waitForTitleAppiumElementPresent()
    {
        return this.waitForElementPresent(
                By.xpath(TITLE_APPIUM_PRESENT),
                "Cannot find article title on page!",
                15
        );
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {

        this.waitForElementAndClick(
                By.xpath(SAVE_BUTTON),
                "Cannot find button to open article options",
                10
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_LIST_BUTTON),
                "Cannot find widget",
                5
        );

        this.waitForElementAndSendKeys(
                By.xpath(INPUT_FIELD),
                name_of_folder,
                "Cannot find text input",
                5
        );

        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Cannot find button to open article options",
                5
        );
    }
}
