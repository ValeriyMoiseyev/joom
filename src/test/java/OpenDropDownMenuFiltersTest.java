import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class OpenDropDownMenuFiltersTest extends BaseTest {

    @Test
    public void openDropDownMenuFiltersTest() {

        MainPage mainPage = new MainPage(androidDriver.get());
//        mainPage.goBack();
        mainPage.goToShopping();
        mainPage.goToSearchPage();

        SearchPage searchPage = new SearchPage(androidDriver.get());
        searchPage.searchByText("Платья");

        SearchResultPage searchResultPage = new SearchResultPage(androidDriver.get());
        searchResultPage.openFilterOptions();

        assertTrue(searchResultPage.getDropDownMenuFilter().isDisplayed());
        assertTrue(searchResultPage.getDropDownMenuFilterTitle().getText().contains("Фильтры"));
    }
}
