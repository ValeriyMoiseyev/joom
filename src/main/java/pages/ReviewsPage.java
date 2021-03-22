package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReviewsPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Отзывы\")")
    private AndroidElement reviewsTitle;

    @AndroidFindBy(id = "com.joom:id/toolbar_layout")
    private AndroidElement reviewsToolbar;

    public ReviewsPage(AndroidDriver driver) {
        super(driver);
    }

    public AndroidElement getReviewsTitle() {
        return reviewsTitle;
    }

    public AndroidElement getReviewsToolbar() {
        return reviewsToolbar;
    }
}
