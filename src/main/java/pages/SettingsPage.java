package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SettingsPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Валюта\")")
    private AndroidElement settings;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)" +
            ".instance(0)).scrollIntoView(new UiSelector().text(\"Доллар США\"));")
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
