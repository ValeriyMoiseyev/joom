import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import pages.SearchResultPage;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static utils.Helper.isSorted;


public class SortByAscendingPriceTest extends BaseTest {

    @Test (description="Сортировка по возрастанию цены")
    public void sortByAscendingPriceTest() throws InterruptedException {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.goToSearchPage();

        SearchPage searchPage = new SearchPage(androidDriver.get());
        searchPage.searchByText("Платья");

        SearchResultPage searchResultPage = new SearchResultPage(androidDriver.get());
        searchResultPage.openSortingOptions();
        searchResultPage.sortByAscendingPrice();
        List<String> prices = searchResultPage.getPrices();
        assertTrue(isSorted(prices));
    }
}
