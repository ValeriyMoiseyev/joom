package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchResultPage extends BasePage {

    private final static String SORTING_SELECTOR = "new UiSelector().text(\"По умолчанию\")";
    private final static String SORTING_BY_ASCENDING_PRICE_SELECTOR = "new UiSelector().text(\"По возрастающей цене\")";
    private final static String PRICE_SELECTOR = "new UiSelector().textContains(\"\u20BD\")";
    private final static String FILTER_SELECTOR = "new UiSelector().text(\"Фильтр\")";

    @AndroidFindBy(uiAutomator = SORTING_SELECTOR)
    private AndroidElement sortingButton;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    @AndroidFindBy(uiAutomator = SORTING_BY_ASCENDING_PRICE_SELECTOR)
    private AndroidElement sortingByAscendingPriceButton;

    @AndroidFindBy(uiAutomator = PRICE_SELECTOR)
    private List<AndroidElement> prices;

    @AndroidFindBy(uiAutomator = FILTER_SELECTOR)
    private AndroidElement filterButton;

    @AndroidFindBy(id = "com.joom:id/bottom_sheet_content")
    private AndroidElement dropDownMenuFilter;

    @AndroidFindBy(id = "com.joom:id/title")
    private AndroidElement dropDownMenuFilterTitle;

    public void openSortingOptions() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.joom:id/product_view")));
        swipeALittleDown();
        sortingButton.click();
    }

    public void sortByAscendingPrice() throws InterruptedException {
        sortingByAscendingPriceButton.click();
        TimeUnit.SECONDS.sleep(3);
        swipeALittleUp();
    }

    public List<Integer> getPrices() {
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            String str = prices.get(i).getText();
            listString.add(str.substring(0, str.length() - 2));
        }
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < listString.size(); i++) {
            int price = Integer.parseInt(listString.get(i));
            listInt.add(price);
        }
        return listInt;
    }

    public void openFilterOptions() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.joom:id/product_view")));
        swipeALittleDown();
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
