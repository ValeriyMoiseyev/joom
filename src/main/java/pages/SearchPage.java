package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BasePage {

    private final static String SEARCH_RESULT_SELECTOR = "new UiSelector().text(\"платья\")";

    @AndroidFindBy(id = "com.joom:id/hint")
    private AndroidElement searchFieldHint;

    @AndroidFindBy(id = "com.joom:id/input")
    private AndroidElement searchFieldInput;

    @AndroidFindBy(uiAutomator = SEARCH_RESULT_SELECTOR)
    private AndroidElement searchResult;

    public void searchByText(String text){
        searchFieldHint.click();
        searchFieldInput.sendKeys(text);
        searchResult.click();
    }

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }
}
