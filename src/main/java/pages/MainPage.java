package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.concurrent.TimeUnit;

import static utils.Helper.elementIsDisplayed;

public class MainPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Подтверждаю\")")
    private AndroidElement submitButton;

    @AndroidFindBy(accessibility = "Профиль")
    private AndroidElement profileButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android." +
            "widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/" +
            "android.widget.FrameLayout/X9/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android." +
            "view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement productPrice;

    @AndroidFindBy(accessibility = "Поиск")
    private AndroidElement searchButton;

    @AndroidFindBy(id = "com.joom:id/product_view")
    private AndroidElement productCard;

    @AndroidFindBy(accessibility = "Лучшее")
    private AndroidElement bestTab;

    @AndroidFindBy(accessibility = "Магазины")
    private AndroidElement marketsTab;

    @AndroidFindBy(accessibility = "Закрыть")
    private AndroidElement closeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Смотреть товар\")")
    private AndroidElement watchProductButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Узнать больше\")")
    private AndroidElement knowMoreButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Спасибо, понятно!\")")
    private AndroidElement understoodButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Перейти к покупкам\")")
    private AndroidElement goToShoppingButton;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public void goToProfile() {
        profileButton.click();
    }

    public void submit() {
        submitButton.click();
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
        swipe.swipeALittleRight(driver);
    }

    public void goToProductCard() {
        productCard.click();
    }

    public void goToShopping() {
        goToShoppingButton.click();
    }

    public void goThroughTheRandomActivitiesToMainPage() {
        if (elementIsDisplayed(submitButton)) {
                submit();
            }

        if (elementIsDisplayed(closeButton)) {
                closeStories();
            }

        if (elementIsDisplayed(watchProductButton)) {
                goBack();
            }

        if (elementIsDisplayed(knowMoreButton)) {
                goBack();
            }

        if (elementIsDisplayed(understoodButton)) {
                goBack();
            }

        if (elementIsDisplayed(knowMoreButton)) {
                goBack();
            }

        if (elementIsDisplayed(goToShoppingButton)) {
                goToShopping();
            }
    }

    public void closeStories(){
        closeButton.click();
    }

    public AndroidElement getBestTab() {
        return bestTab;
    }

    public AndroidElement getMarketsTab() {
        return marketsTab;
    }

    public AndroidElement getCloseButton() {
        return closeButton;
    }

    public AndroidElement getSubmitButton() {
        return submitButton;
    }

    public AndroidElement getGoToShoppingButton() {
        return goToShoppingButton;
    }
}
