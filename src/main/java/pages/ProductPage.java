package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private final static String REVIEWS_SELECTOR = "new UiSelector().textContains(\"Отзывы\")";

    @AndroidFindBy(uiAutomator = REVIEWS_SELECTOR)
    private AndroidElement reviews;

    @AndroidFindBy(id = "com.joom:id/product_info_current_price_label")
    private AndroidElement price;

    public void openReviews() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("com.joom:id/product_info_current_price_label")));
        swipeALittleUp();
        swipeALittleUp();
        reviews.click();
    }

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }
}
