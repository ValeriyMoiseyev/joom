package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage extends BasePage {

    private final static String FEED_SWIPE_REFRESH_SELECTOR = "com.joom:id/feed_swipe_refresh";

    @AndroidFindBy(id = "com.joom:id/feed_swipe_refresh")
        private AndroidElement feed;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    public void refreshFavorites() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id(FEED_SWIPE_REFRESH_SELECTOR)));
        swipeALittleDown();
    }

    public FavoritesPage(AndroidDriver driver) {
        super(driver);
    }

    public AndroidElement getProductCard() {
        return productCard;
    }
}
