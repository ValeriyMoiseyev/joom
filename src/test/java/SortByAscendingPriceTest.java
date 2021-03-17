import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import pages.SearchResultPage;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class SortByAscendingPriceTest extends BaseTest {

    @Test
    public void sortByAscendingPriceTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goBack();
        mainPage.goToSearchPage();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchByText("Платья");

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openSortingOptions();
        searchResultPage.sortByAscendingPrice();
        List<Integer> prices = searchResultPage.getPrices();
        for (int i = 0; i < prices.size(); i++) {
            if (i < prices.size() - 1) {
                assertTrue(prices.get(i) <= prices.get(i + 1));
                System.out.println(prices.get(i));
            }
        }
    }
}
