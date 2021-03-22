package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.joom:id/button_title")
    private AndroidElement goToShoppingButton;

    @AndroidFindBy(accessibility = "Профиль")
    private AndroidElement profileButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android" +
            ".widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget" +
            ".FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/X9/android.view.ViewGroup/androidx" +
            ".recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement productPrice;

    @AndroidFindBy(accessibility = "Поиск")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    @AndroidFindBy(accessibility = "Лучшее")
    private AndroidElement bestTab;

    @AndroidFindBy(accessibility = "Магазины")
    private AndroidElement marketsTab;

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

    public void selectMarketsTab() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        swipeALittleRight();
    }

    public void goToProductCard() {
        productCard.click();
    }

    public AndroidElement getBestTab() {
        return bestTab;
    }

    public AndroidElement getMarketsTab() {
        return marketsTab;
    }
}
