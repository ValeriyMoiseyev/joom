package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Swipe;
import utils.Waiters;


public abstract class BasePage {
    public AndroidDriver driver;
    public WebDriverWait wait;
    public Waiters waiters = new Waiters();
    public Swipe swipe = new Swipe();
    private final static String BUTTON_TITLE_SELECTOR = "com.joom:id/button_title";

    public void goBack() {
        waiters.waitElement(By.id(BUTTON_TITLE_SELECTOR), driver, wait);
        driver.navigate().back();
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
