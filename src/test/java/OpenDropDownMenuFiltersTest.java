import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import pages.SearchResultPage;

import static org.testng.Assert.assertTrue;

public class OpenDropDownMenuFiltersTest extends BaseTest {

    @Test (description="Отображение выпадающего меню с фильтрами")
    public void openDropDownMenuFiltersTest() {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.goToSearchPage();

        SearchPage searchPage = new SearchPage(androidDriver.get());
        searchPage.searchByText("Платья");

        SearchResultPage searchResultPage = new SearchResultPage(androidDriver.get());
        searchResultPage.openFilterOptions();

        assertTrue(searchResultPage.getDropDownMenuFilter().isDisplayed());
        assertTrue(searchResultPage.getDropDownMenuFilterTitle().getText().contains("Фильтры"));
    }
}
