package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SavePageObject extends MainPageObject{

    public static final String
            FOLDER_BY_NAME_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLE}']";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace(
                "{FOLDER_NAME}",
                name_of_folder
        );
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace(
                "{TITLE}",
                article_title
        );
    }

    public SavePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "Cannot find button created folder " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath),
                "Cannot find saved article by title " + article_title,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath),
                "Saved article still present with title " + article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Cannot find saved article"
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
