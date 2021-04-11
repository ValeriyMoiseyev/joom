package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Swipe {

    public void swipeALittleDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int topY = (int)(size.getHeight()  * 0.72D);
        int centerY = size.getHeight() / 2;
        int centerX = size.getWidth() / 2;
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(centerX, centerY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(centerX, topY));
        action.release();
        action.perform();
    }

    public void swipeALittleUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int botY = (int)(size.getHeight()  * 0.15D);
        int centerY = size.getHeight() / 2;
        int centerX = size.getWidth() / 2;
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(centerX, centerY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(centerX, botY));
        action.release();
        action.perform();
    }

    public void swipeALittleRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int leftX = (int)(size.getWidth() * 0.9D);
        int rightX = (int)(size.getWidth()  * 0.1D);
        int centerY = size.getHeight() / 2;
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(leftX, centerY));
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
        action.moveTo(PointOption.point(rightX, centerY));
        action.release();
        action.perform();
    }
}
