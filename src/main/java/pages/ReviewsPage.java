package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReviewsPage extends BasePage {

    private final static String REVIEWS_TITLE_SELECTOR = "new UiSelector().textContains(\"Отзывы\")";

    @AndroidFindBy(uiAutomator = REVIEWS_TITLE_SELECTOR)
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
