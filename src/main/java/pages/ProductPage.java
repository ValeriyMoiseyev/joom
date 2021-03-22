package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Отзывы\")")
    private AndroidElement reviews;

    @AndroidFindBy(id = "com.joom:id/product_info_current_price_label")
    private AndroidElement price;

    @AndroidFindBy(id = "com.joom:id/like_button")
    private AndroidElement likeButton;

    public void openReviews() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("com.joom:id/product_info_current_price_label")));
        swipeALittleUp();
        swipeALittleUp();
        reviews.click();
    }

    public void addToFavorites(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("com.joom:id/like_button")));
        likeButton.click();
    }

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }
}
