package utils;

import com.google.common.collect.Ordering;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

public class Helper {
    public static boolean isSorted(List<String> listOfStrings) {
        return Ordering.<String>natural().isOrdered(listOfStrings);
    }

    public static boolean elementIsDisplayed(AndroidElement element) {
        try {
            if (element.isDisplayed()) {
                System.out.println("Element is displayed");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
