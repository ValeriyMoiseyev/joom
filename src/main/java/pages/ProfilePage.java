package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BasePage {

    @AndroidFindBy(accessibility = "Настройки")
    private AndroidElement settingsButton;

    @AndroidFindBy(accessibility = "Главная")
    private AndroidElement mainPageButton;

    public void goToSettings() {
        settingsButton.click();
    }

    public void goToMainPage() {
        mainPageButton.click();
    }

    public ProfilePage(AndroidDriver driver) {
        super(driver);
    }
}
