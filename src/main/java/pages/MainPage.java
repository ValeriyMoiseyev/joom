package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private final static String PRICE_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android" +
            ".widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget" +
            ".FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/X9/android.view.ViewGroup/androidx" +
            ".recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";

    @AndroidFindBy(id = "com.joom:id/button_title")
    private AndroidElement goToShoppingButton;

    @AndroidFindBy(accessibility = "Профиль")
    private AndroidElement profileButton;

    @AndroidFindBy(xpath = PRICE_XPATH)
    private AndroidElement productPrice;

    @AndroidFindBy(accessibility = "Поиск")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public void goToProfile() {
        profileButton.click();
    }

    public void goToShopping() {
        goToShoppingButton.click();
    }

    public String getPrice() {
        String result = productPrice.getText();
        return result;
    }

    public void goToSearchPage() {
        searchButton.click();
    }

    public void goBack() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.joom:id/button_title")));
        driver.navigate().back();
    }

    public void goToProductCard() {
        productCard.click();
    }
}
