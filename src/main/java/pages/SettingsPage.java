package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SettingsPage extends BasePage {

    private final static String CURRENCY_SELECTOR = "new UiSelector().text(\"Валюта\")";
    private final static String USD_SELECTOR = "new UiSelector().text(\"Доллар США\")";
    private final static String SCROLL_CURRENCY_COMMAND = "new UiScrollable(new UiSelector().scrollable(true)" +
            ".instance(0)).scrollIntoView(" + USD_SELECTOR + ");";

    @AndroidFindBy(uiAutomator = CURRENCY_SELECTOR)
    private AndroidElement settings;

    @AndroidFindBy(uiAutomator = SCROLL_CURRENCY_COMMAND)
    private AndroidElement usd;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private AndroidElement backButton;

    public void openCurrencyList() {
        settings.click();
    }

    public void changeCurrencyToUsd() {
        usd.click();
    }

    public void goToProfile() {
        backButton.click();
    }

    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }
}
