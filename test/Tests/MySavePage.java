package Tests;

import lib.CoreTestCase;
import lib.Ui.ArticlePageObject;
import lib.Ui.NavigationUi;
import lib.Ui.SavePageObject;
import lib.Ui.SearchPageObject;
import org.junit.Test;

public class MySavePage extends CoreTestCase
{

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming language)");
        SearchPageObject.waitForSearchResultAndClick("Java (programming language)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Test";
        ArticlePageObject.addArticleToMyList(name_of_folder);

        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickSave();

        SavePageObject SavePageObject = new SavePageObject(driver);
        SavePageObject.openFolderName(name_of_folder);
        SavePageObject.swipeByArticleToDelete(article_title);

    }

}
