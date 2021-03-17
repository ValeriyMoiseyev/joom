import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import pages.SettingsPage;

import static org.testng.Assert.assertTrue;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void changeCurrencyTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goBack();
        mainPage.goToProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openCurrencyList();
        settingsPage.changeCurrencyToUsd();
        settingsPage.goToProfile();

        profilePage.goToMainPage();

        String price = mainPage.getPrice();

        assertTrue(price.contains("$"));
        System.out.println(price);
    }
}
