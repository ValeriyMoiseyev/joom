import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import pages.SettingsPage;

import static org.testng.Assert.assertTrue;

public class ChangeCurrencyTest extends BaseTest {

    @Ignore
    @Test (description="Выбор валюты")
    public void changeCurrencyTest() throws InterruptedException {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.goToProfile();

        ProfilePage profilePage = new ProfilePage(androidDriver.get());
        profilePage.goToSettings();

        SettingsPage settingsPage = new SettingsPage(androidDriver.get());
        settingsPage.openCurrencyList();
        settingsPage.changeCurrencyToUsd();
        settingsPage.goToProfile();

        profilePage.goToMainPage();
        String price = mainPage.getPrice();
        assertTrue(price.contains("$"));
    }
}
