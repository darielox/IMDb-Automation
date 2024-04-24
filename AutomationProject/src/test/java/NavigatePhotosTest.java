import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigatePhotosTest extends BaseTest {

    @Test
    public void navigateThroughPhotos() throws InterruptedException {
        // Step 1: Open the IMDb page for "The Godfather: Part II"
        driver.get("https://www.imdb.com/title/tt0071562/");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
        Thread.sleep(1000);

        // Step 2: Click on the specified photo to enter gallery view
        WebElement photo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='photos-image-overlay-1']")));
        photo.click();
        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) { // click "Next" 10 times
            // Wait for the "Next" button to become clickable
            WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Next']")));

            nextButton.click();

            // Add a 1-second pause between each click
            Thread.sleep(1000);
        }
    }
}
