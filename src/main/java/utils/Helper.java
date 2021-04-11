package utils;

import com.google.common.collect.Ordering;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

public class Helper {
    public static boolean isSorted(List<String> listOfStrings) {
        return Ordering.<String>natural().isOrdered(listOfStrings);
    }

    public static boolean checkActivity(AndroidElement element) {
        Boolean res = null;
        try {
            if (element.isDisplayed()) {
                res = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }
}
