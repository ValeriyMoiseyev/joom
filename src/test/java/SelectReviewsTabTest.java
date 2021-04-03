import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.ReviewsPage;

import static org.testng.Assert.assertTrue;

public class SelectReviewsTabTest extends BaseTest {

    @Test (description="Отображение экрана \"Отзывы\"")
    public void selectReviewsTabTest() {
        MainPage mainPage = new MainPage(androidDriver.get());
        mainPage.goThroughTheRandomActivitiesToMainPage();
        mainPage.goToProductCard();

        ProductPage productPage = new ProductPage(androidDriver.get());
        productPage.openReviews();

        ReviewsPage reviewsPage = new ReviewsPage(androidDriver.get());
        assertTrue(reviewsPage.getReviewsTitle().isDisplayed());
        assertTrue(reviewsPage.getReviewsToolbar().isDisplayed());
        assertTrue(reviewsPage.getReviewsToolbar().getSize().height > 0 &&
                reviewsPage.getReviewsToolbar().getSize().width > 0);
    }
}
