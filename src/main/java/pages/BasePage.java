package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public AndroidDriver driver;
    public WebDriverWait wait;

    public void swipeALittleDown() {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(540, 1000));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)));
        action.moveTo(PointOption.point(540, 1400));
        action.release();
        action.perform();
    }

    public void swipeALittleUp() {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(540, 1080));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)));
        action.moveTo(PointOption.point(540, 300));
        action.release();
        action.perform();
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
