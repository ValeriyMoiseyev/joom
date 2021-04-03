package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Swipe {
    public void swipeALittleDown(AndroidDriver driver) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(540, 1000));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(540, 1400));
        action.release();
        action.perform();
    }

    public void swipeALittleUp(AndroidDriver driver) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(540, 1080));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(540, 300));
        action.release();
        action.perform();
    }

    public void swipeALittleRight(AndroidDriver driver) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(1000, 700));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(100, 700));
        action.release();
        action.perform();
    }
}
