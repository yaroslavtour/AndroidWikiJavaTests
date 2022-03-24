package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_SKIP_PAGE = "//*[contains(@text,'SKIP')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_LANGUAGE_BUTTON = "org.wikipedia:id/search_lang_button",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Linkin Park discography']",
            SEARCH_EMPTY_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/results_text'][@text='No results']";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return  SEARCH_RESULT_BY_SUBSTRING_TPL.replace(
                "{SUBSTRING}",
                substring);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementAndClick(
                By.xpath(SEARCH_SKIP_PAGE),
                "Cannot find element to skip",
                5
        );
        this.waitForElementAndClick(
                By.xpath(SEARCH_INIT_ELEMENT),
                "Cannot find element to init search",
                5
        );
        this.waitForElementPresent(
                By.xpath(SEARCH_INIT_ELEMENT),
                "Cannot find search input after clicking search init element"
        );
    }

    public void waitForLanguageButtonToAppear()
    {
        this.waitForElementPresent(
                By.id(SEARCH_LANGUAGE_BUTTON),
                "Cannot find search language button!",
                5
        );
    }

    public void waitForLanguageButtonToDisappear()
    {
        this.waitForElementNotPresent(
                By.id(SEARCH_LANGUAGE_BUTTON),
                "Search language button is still present!",
                5
        );
    }

    public void clickLanguageButton()
    {
        this.waitForElementAndClick(
                By.id(SEARCH_LANGUAGE_BUTTON),
                "Cannot find and click search language button!",
                5
        );
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(
                By.xpath(SEARCH_INPUT),
                search_line, "Cannot find and type search input!",
                5
        );
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                By.xpath(search_result_xpath),
                "Cannot find search result with substring " + substring,
                15
        );
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot find and click search result with substring " + substring,
                10
        );
    }

    public void waitForSearchResultAndClick(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot find search result with substring " + substring,
                10
        );
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request.",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),
                "Cannot find empty result element.",
                15
        );
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNoPresent(By.xpath(SEARCH_RESULT_ELEMENT),
                "We supposed not to find any results."
        );
    }
}
