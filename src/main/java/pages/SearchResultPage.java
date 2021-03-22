package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Iterables.isEmpty;


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
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PRODUCT_VIEW_SELECTOR)));
        swipeALittleDown();
        sortingButton.click();
    }

    public void sortByAscendingPrice() throws InterruptedException {
        sortingByAscendingPriceButton.click();
        TimeUnit.SECONDS.sleep(3);
        swipeALittleUp();
    }

    public List<String> getPrices() {
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            String str = prices.get(i).getText();
            listString.add(str);
        }

        return listString;
    }

    public static boolean isSorted(List<String> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public void openFilterOptions() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PRODUCT_VIEW_SELECTOR)));
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
