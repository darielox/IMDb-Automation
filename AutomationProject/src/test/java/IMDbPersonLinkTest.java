import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IMDbPersonLinkTest extends BaseTest {

    @Test
    public void testClickPersonLinks() throws InterruptedException {
        // Navigate to "The Godfather: Part II" page
        driver.get("https://www.imdb.com/title/tt0071562/");
        Thread.sleep(2000);
        // Array of names to click on
        String[] names = {"Francis Ford Coppola", "Mario Puzo", "Al Pacino", "Robert De Niro", "Robert Duvall"};

        for (String name : names) {
            // Find the hyperlink for each name and click it
            // Note: The actual selectors might need to be adjusted based on the page structure.
            WebElement link = driver.findElement(By.linkText(name));
            link.click();

            // Optional: Add verification here (e.g., checking the URL or page title)

            // Navigate back to the movie page to click the next link
            driver.navigate().back();
        }
    }
}