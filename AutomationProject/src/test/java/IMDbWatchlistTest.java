import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class IMDbWatchlistTest extends BaseTest {

    @Test
    public void addToWatchlist() throws InterruptedException {
        // Assuming login is handled within BaseTest or through a separate method
        // Navigate to a specific movie page, for example, "The Godfather II"
        driver.get("https://www.imdb.com/title/tt0071562/");

        // Click the "Add to Watchlist" button. Adjust the selector if necessary.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToWatchlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='tm-box-wl-button']")));
        addToWatchlistButton.click();
        Thread.sleep(1000);
        // Optional: Assert or verify the movie was added successfully
        // This might involve checking the button's state change or navigating to the watchlist page to verify the movie's presence.
    }
}