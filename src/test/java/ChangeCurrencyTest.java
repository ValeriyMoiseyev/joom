import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import pages.SettingsPage;

import static org.testng.Assert.assertTrue;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void changeCurrencyTest() {
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
        System.out.println(price);
    }
}
