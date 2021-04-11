package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchResultPage extends BasePage {

    private final static String PRODUCT_VIEW_SELECTOR = "com.joom:id/product_view";

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"По умолчанию\")")
    private AndroidElement sortingButton;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"По возрастающей цене\")")
    private AndroidElement sortingByAscendingPriceButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"£\")")
    private List<AndroidElement> prices;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Фильтр\")")
    private AndroidElement filterButton;

    @AndroidFindBy(id = "com.joom:id/bottom_sheet_content")
    private AndroidElement dropDownMenuFilter;

    @AndroidFindBy(id = "com.joom:id/title")
    private AndroidElement dropDownMenuFilterTitle;

    public void openSortingOptions() {
        waiters.waitElement(By.id(PRODUCT_VIEW_SELECTOR), driver, wait);
        swipe.swipeALittleDown(driver);
        sortingButton.click();
    }

    public void sortByAscendingPrice() throws InterruptedException {
        sortingByAscendingPriceButton.click();
        TimeUnit.SECONDS.sleep(3);
        swipe.swipeALittleUp(driver);
    }

    public List<String> getPrices() {
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            String str = prices.get(i).getText();
            listString.add(str);
        }
        return listString;
    }

    public void openFilterOptions() {
        waiters.waitElement(By.id(PRODUCT_VIEW_SELECTOR), driver, wait);
        swipe.swipeALittleDown(driver);
        filterButton.click();
    }

    public AndroidElement getDropDownMenuFilter() {
        return dropDownMenuFilter;
    }

    public AndroidElement getDropDownMenuFilterTitle() {
        return dropDownMenuFilterTitle;
    }

    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }
}
