package utils;

import com.google.common.collect.Ordering;

import java.util.List;

public class Helper {
    public static boolean isSorted(List<String> listOfStrings) {
        return Ordering.<String>natural().isOrdered(listOfStrings);
    }
}
