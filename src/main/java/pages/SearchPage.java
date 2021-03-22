package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BasePage {

    @AndroidFindBy(id = "com.joom:id/hint")
    private AndroidElement searchFieldHint;

    @AndroidFindBy(id = "com.joom:id/input")
    private AndroidElement searchFieldInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"платья\")")
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
