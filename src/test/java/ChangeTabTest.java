import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ChangeTabTest extends BaseTest {

    @Test (description="Смена вкладки")
    public void changeTabTest() throws InterruptedException {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.selectMarketsTab();
        assertTrue(mainPage.getMarketsTab().isSelected());
        assertFalse(mainPage.getBestTab().isSelected());
    }
}
