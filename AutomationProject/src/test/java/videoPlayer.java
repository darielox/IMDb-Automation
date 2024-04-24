import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.Duration;

public class videoPlayer extends BaseTest {

    @Test
    public void testClickPersonLinks() throws InterruptedException {
        // Navigate to "The Godfather: Part II" page
        driver.get("https://www.imdb.com/title/tt0071562/");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);

        // Locate the video play button using its 'data-testid' and click it
        WebElement videoPlayButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='videos-slate-overlay-1']")));
        videoPlayButton.click();
        Thread.sleep(30000);
    }
}