import org.testng.annotations.Test;
import pages.FavoritesPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ProfilePage;

import static org.testng.Assert.assertTrue;

public class AddProductToFavoritesTest extends BaseTest {

    @Test (description="Добавление в избранное")
    public void changeTabTest() {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.goToProductCard();

        ProductPage productPage = new ProductPage(androidDriver.get());
        productPage.addToFavorites();
        productPage.goBack();

        mainPage.goToProfile();
        ProfilePage profilePage = new ProfilePage(androidDriver.get());
        profilePage.goToFavorites();

        FavoritesPage favoritesPage = new FavoritesPage(androidDriver.get());
        favoritesPage.refreshFavorites();
        assertTrue(favoritesPage.getProductCard().isDisplayed());
    }
}