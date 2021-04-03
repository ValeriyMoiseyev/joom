import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    private WebDriverWait wait;
    public ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<>();

    protected AndroidDriver getDriver() {
        return androidDriver.get();
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.20.2");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "");
        caps.setCapability("platformVersion","9.0");
        caps.setCapability("platformName","Android");
        caps.setCapability("app","/opt/Joom Shopping for every day_v3.64.0_apkpure.com.apk");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.joom");
        caps.setCapability("appActivity", "com.joom.ui.main.MainActivity");
        caps.setCapability("noReset", "false");
        caps.setCapability("language", "ru");
        caps.setCapability("locale", "RU");

        try {
            androidDriver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        sessionId.set(((AndroidDriver)androidDriver.get()).getSessionId().toString());
    }

    @AfterMethod
    public void teardown() {
        androidDriver.get().quit();
    }
}
