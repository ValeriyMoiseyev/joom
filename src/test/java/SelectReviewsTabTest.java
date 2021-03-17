import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.ReviewsPage;

import static org.testng.Assert.assertTrue;

public class SelectReviewsTabTest extends BaseTest {

    @Test
    public void selectReviewsTabTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.goBack();
        mainPage.goToProductCard();

        ProductPage productPage = new ProductPage(driver);
        productPage.openReviews();

        ReviewsPage reviewsPage = new ReviewsPage(driver);
        assertTrue(reviewsPage.getReviewsTitle().isDisplayed());
        assertTrue(reviewsPage.getReviewsToolbar().isDisplayed());
        assertTrue(reviewsPage.getReviewsToolbar().getSize().height > 0 &&
                reviewsPage.getReviewsToolbar().getSize().width > 0);
        System.out.println(reviewsPage.getReviewsToolbar().getSize().height + " x " +
                reviewsPage.getReviewsToolbar().getSize().width);
    }
}
