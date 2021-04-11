package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private final static String CURRENT_PRICE_SELECTOR = "com.joom:id/product_info_current_price_label";
    private final static String LIKE_BUTTON_SELECTOR = "com.joom:id/like_button";

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Отзывы\")")
    private AndroidElement reviews;

    @AndroidFindBy(id = "com.joom:id/product_info_current_price_label")
    private AndroidElement price;

    @AndroidFindBy(id = "com.joom:id/like_button")
    private AndroidElement likeButton;

    public void openReviews() {
        waiters.waitElement(By.id(CURRENT_PRICE_SELECTOR), driver, wait);
        swipe.swipeALittleUp(driver);
        swipe.swipeALittleUp(driver);
        reviews.click();
    }

    public void addToFavorites(){
        waiters.waitElement(By.id(LIKE_BUTTON_SELECTOR), driver, wait);
        likeButton.click();
    }

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }
}
