package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class FavoritesPage extends BasePage {

    private final static String FEED_SWIPE_REFRESH_SELECTOR = "com.joom:id/feed_swipe_refresh";

    @AndroidFindBy(id = "com.joom:id/feed_swipe_refresh")
        private AndroidElement feed;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    public void refreshFavorites() {
        waiters.waitElement(By.id(FEED_SWIPE_REFRESH_SELECTOR), driver, wait);
        swipe.swipeALittleDown(driver);
    }

    public FavoritesPage(AndroidDriver driver) {
        super(driver);
    }

    public AndroidElement getProductCard() {
        return productCard;
    }
}
