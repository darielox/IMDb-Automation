import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAndVerifyMovieTest extends BaseTest {

    @Test
    public void testSearchAndVerifyMovie() throws InterruptedException  {
        driver.get("https://www.imdb.com");
        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        searchBox.sendKeys("Godfather" + Keys.ENTER);

        // Wait for search results to load and select the movie
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'II')]"))).click();
        Thread.sleep(1000);

        WebElement movieTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='hero__pageTitle']")));
        Assert.assertTrue(movieTitle.getText().contains("The Godfather Part II"), "Movie details page did not load correctly.");
    }
}
